import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Lab3 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        double spacing = 20;

        Font defaultFont = new Font(16);

        Label checkboxLabel;
        TextField checkboxField;
        Label radioLabel;
        TextField radioField;

        Label comboLabel;
        TextField comboField;

        CheckBox checkBox1;
        CheckBox checkBox2;

        RadioButton radio1;
        RadioButton radio2;
        RadioButton radio3;

        ToggleGroup toggleGroup;

        ComboBox<String> combo;

        GridPane pane = new GridPane();

        pane.setHgap(spacing * 3);
        pane.setVgap(spacing);
        pane.setPadding(new Insets(spacing * 1.5));

        checkboxLabel = new Label("Checkbox State");
        checkboxLabel.setFont(defaultFont);
        pane.add(checkboxLabel, 0, 0);

        checkboxField = new TextField();
        checkboxField.setEditable(false);
        checkboxField.setFont(defaultFont);
        pane.add(checkboxField, 1, 0);

        radioLabel = new Label("Radio State");
        radioLabel.setFont(defaultFont);
        pane.add(radioLabel, 0, 1);

        radioField = new TextField();
        radioField.setEditable(false);
        radioField.setFont(defaultFont);
        pane.add(radioField, 1, 1);

        comboLabel = new Label("Combo State");
        comboLabel.setFont(defaultFont);
        pane.add(comboLabel, 0, 2);

        comboField = new TextField();
        comboField.setEditable(false);
        comboField.setFont(defaultFont);
        pane.add(comboField, 1, 2);

        checkBox1 = new CheckBox("Driver");
        checkBox1.setFont(defaultFont);
        pane.add(checkBox1, 0, 3);

        checkBox2 = new CheckBox("Passenger");
        checkBox2.setFont(defaultFont);
        pane.add(checkBox2, 0, 4);

        checkBox1.setOnAction(e -> checkboxField.setText(
                (checkBox1.isSelected() ? checkBox1.getText() : "")
                        + (checkBox2.isSelected() ? checkBox2.getText() : "")));
        checkBox2.setOnAction(checkBox1.getOnAction()); // same event handler for both checkboxes

        radio1 = new RadioButton("Single");
        radio1.setFont(defaultFont);
        pane.add(radio1, 1, 3);

        radio2 = new RadioButton("Married");
        radio2.setFont(defaultFont);
        pane.add(radio2, 1, 4);

        radio3 = new RadioButton("Divorced");
        radio3.setFont(defaultFont);
        pane.add(radio3, 1, 5);

        toggleGroup = new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(e -> radioField.setText(
                radio1.isSelected() ? radio1.getText() : radio2.isSelected() ? radio2.getText() : radio3.getText()));
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);

        combo = new ComboBox<>();
        combo.setItems(FXCollections.observableArrayList("Swimming", "Reading"));
        combo.setOnAction(e -> comboField.setText(combo.getSelectionModel().getSelectedItem()));
        combo.getSelectionModel().selectFirst();
        pane.add(combo, 0, 6);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
