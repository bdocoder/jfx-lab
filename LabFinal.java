import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabFinal extends Application {

  enum Gender {
    Male, Female
  }

  enum Location {
    Egypt,
    Turkey,
    London,
    USA,
  }

  enum Language {
    Arabic,
    English,
    Spanish,
    Turkish,
    French,
  }

  VBox adminInnerVBox;

  Stage registerStage;

  HashMap<String, Boolean> languages;

  double spacing = 15;
  Insets defaultPadding = new Insets(spacing);

  public static void main(String... args) {
    launch(args);
  }

  MenuBar createAdminMenuBar() {
    MenuBar menu = new MenuBar();
    Menu fileMenu = new Menu("File");
    MenuItem registerItem = new MenuItem("Register");
    registerItem.setOnAction(e -> registerStage.show());
    fileMenu.getItems().add(registerItem);
    menu.getMenus().add(fileMenu);
    return menu;
  }

  Scene createAdminScene() {
    adminInnerVBox = new VBox();
    adminInnerVBox.setPadding(defaultPadding);
    adminInnerVBox.setSpacing(spacing);
    return new Scene(new VBox(createAdminMenuBar(), adminInnerVBox), 640, 480);
  }

  Scene createRegisterScene() {
    GridPane gp1 = new GridPane();
    gp1.setHgap(spacing);
    gp1.setVgap(spacing);

    TextField nameField = new TextField();

    gp1.add(new Label("Name"), 0, 0);
    gp1.add(nameField, 1, 0);

    TextField emailField = new TextField();

    gp1.add(new Label("Email"), 0, 1);
    gp1.add(emailField, 1, 1);

    GridPane gp2 = new GridPane();
    gp2.setHgap(spacing);
    gp2.setVgap(spacing);

    ComboBox<Location> comboBox = new ComboBox<>();
    comboBox.getItems().addAll(Location.values());
    comboBox.getSelectionModel().selectFirst();

    gp2.add(new Label("Location"), 0, 0);
    gp2.add(comboBox, 1, 0);

    gp2.add(new Label("Languages"), 0, 1);
    int c1 = 0; // counter
    for (Language l : Language.values()) {
      String lang = l.name();
      CheckBox checkBox = new CheckBox(lang);
      checkBox.setOnAction(e -> languages.put(lang, checkBox.isSelected()));
      gp2.add(checkBox, ++c1, 1);
    }

    gp2.add(new Label("Gender"), 0, 2);
    ToggleGroup toggleGroup = new ToggleGroup();
    int c2 = 0; // counter
    for (Gender g : Gender.values()) {
      RadioButton radioButton = new RadioButton(g.name());
      radioButton.setToggleGroup(toggleGroup);
      gp2.add(radioButton, ++c2, 2);
    }

    Button cta = new Button("Register"); // call to action (primary button)
    cta.setOnAction(e -> {
      String name = nameField.getText();
      String email = emailField.getText();
      String location = comboBox.getSelectionModel().getSelectedItem().name();
      StringBuilder languagesSB = new StringBuilder(); // another way to construct strings
      int length = languages.size(), c3 = 0;
      for (var l : Language.values()) {
        String lang = l.name();
        if (languages.containsKey(lang) && languages.get(lang).booleanValue()) {
          languagesSB.append(lang);
          if (c3++ < length - 1)
            languagesSB.append(" - "); // separator between languages
        }
      }
      String gender = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
      adminInnerVBox.getChildren().add(new Label(
          name + " " + email + " (" + gender + ") in " + location + " with languages: " + languagesSB.toString()));
      registerStage.hide();
    });

    VBox vBox = new VBox(gp1, gp2, cta);
    vBox.setSpacing(spacing * 3);
    vBox.setPadding(defaultPadding);

    return new Scene(vBox);
  }

  public void start(Stage stage) {
    registerStage = new Stage();
    registerStage.setScene(createRegisterScene());
    registerStage.setTitle("Register Panel");

    stage.setScene(createAdminScene());
    stage.setTitle("Admin Panel");
    stage.show();
  }

  @Override
  public void init() {
    languages = new HashMap<>();
  }
}
