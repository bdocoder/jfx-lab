import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Lab4 extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    double spacing = 10;
    var padding = new Insets(spacing);

    BorderPane outerBorderPane = new BorderPane();

    HBox headerBox = new HBox();
    headerBox.setSpacing(spacing);
    headerBox.setPadding(padding);

    Button dbConnectButton = new Button("DB Connect");
    Button dbDisconnectButton = new Button("DB Disconnect");
    headerBox.getChildren().addAll(dbConnectButton, dbDisconnectButton);

    outerBorderPane.setTop(headerBox);

    outerBorderPane.setRight(new Pane());

    BorderPane innerBorderPane = new BorderPane();
    innerBorderPane.setPadding(padding);

    // db 1: create
    GridPane cFormPane = new GridPane();
    cFormPane.setHgap(spacing);
    cFormPane.setVgap(spacing);
    cFormPane.setPadding(padding);

    String[] labels = { "Name", "Surname", "Email", "Telephone" };
    for (int i = 0; i < labels.length; i++) {
      cFormPane.add(new Label(labels[i]), 0, i);
      TextField textField = new TextField();
      textField.setPromptText(labels[i].toLowerCase());
      cFormPane.add(textField, 1, i);
    }
    cFormPane.add(new Button("Add Employee"), 0, 4);

    // db 2: read update delete
    GridPane rudFormPane = new GridPane();
    rudFormPane.setHgap(spacing);
    rudFormPane.setVgap(spacing);
    rudFormPane.setPadding(padding);

    String[] labels2 = { "Employee ID", "New Email" };
    for (int i = 0; i < labels2.length; i++) {
      rudFormPane.add(new Label(labels2[i]), i, 0);
      TextField textField = new TextField();
      textField.setPromptText(labels2[i].toLowerCase());
      rudFormPane.add(textField, i, 1);
    }
    HBox rudFormButtons = new HBox();
    rudFormButtons.setSpacing(spacing);
    rudFormButtons.setPadding(padding);
    rudFormButtons.setAlignment(Pos.CENTER);

    String[] buttons2 = { "Search", "Update", "Delete" };
    for (int i = 0; i < buttons2.length; i++) {
      rudFormButtons.getChildren().add(new Button(buttons2[i]));
    }
    rudFormPane.add(rudFormButtons, 0, 2, 2, 1);

    innerBorderPane.setLeft(cFormPane);
    innerBorderPane.setRight(rudFormPane);
    outerBorderPane.setCenter(innerBorderPane);

    TextArea ta = new TextArea();
    ta.setPrefSize(300, 100);
    ta.setPromptText("Result Console");
    outerBorderPane.setBottom(ta);

    Scene scene = new Scene(outerBorderPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
