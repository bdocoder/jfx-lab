import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Lab5 extends Application {
  double spacing = 10;
  GridPane pane;
  double buttonWidth = spacing * 4;
  Font monoFont = new Font("monospace", 16);
  Font monoFontSmall = new Font("monospace", 12);

  public static void main(String[] args) {
    launch(args);
  }

  void createButton(String text, int col, int row, int colSpan, int rowSpan, Color bgColor) {
    Button button = new Button(text);
    button.setAlignment(Pos.CENTER);
    button.setFont(monoFontSmall);
    double finalWidth = buttonWidth + (colSpan - 1) * (buttonWidth + spacing);
    double finalHeight = buttonWidth + (rowSpan - 1) * (buttonWidth + spacing);
    button.setPrefSize(finalWidth, finalHeight);
    button.setBackground(new Background(new BackgroundFill(bgColor, null, null)));
    button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
    pane.add(button, col, row, colSpan, rowSpan);
  }

  @Override
  public void start(Stage primaryStage) {

    pane = new GridPane();
    pane.setHgap(spacing);
    pane.setVgap(spacing);
    pane.setPadding(new Insets(spacing * 1.5));

    TextField textField = new TextField("0");
    textField.setAlignment(Pos.BOTTOM_RIGHT);
    textField.setEditable(false);
    textField.setPrefHeight(spacing * 5);
    textField.setFont(monoFont);
    textField.setBackground(new Background(new BackgroundFill(Color.rgb(230, 238, 249), null, null)));
    pane.add(textField, 0, 0);
    GridPane.setColumnSpan(textField, 5);

    createButton("MC", 0, 1, 1, 1, Color.TRANSPARENT);
    createButton("MR", 1, 1, 1, 1, Color.TRANSPARENT);
    createButton("MS", 2, 1, 1, 1, Color.TRANSPARENT);
    createButton("M+", 3, 1, 1, 1, Color.TRANSPARENT);
    createButton("M-", 4, 1, 1, 1, Color.TRANSPARENT);

    createButton("←", 0, 2, 1, 1, Color.LIGHTBLUE);
    createButton("CE", 1, 2, 1, 1, Color.LIGHTBLUE);
    createButton("C", 2, 2, 1, 1, Color.LIGHTBLUE);
    createButton("±", 3, 2, 1, 1, Color.LIGHTBLUE);
    createButton("√", 4, 2, 1, 1, Color.LIGHTBLUE);

    createButton("7", 0, 3, 1, 1, Color.WHITE);
    createButton("8", 1, 3, 1, 1, Color.WHITE);
    createButton("9", 2, 3, 1, 1, Color.WHITE);
    createButton("/", 3, 3, 1, 1, Color.LIGHTBLUE);
    createButton("%", 4, 3, 1, 1, Color.LIGHTBLUE);

    createButton("4", 0, 4, 1, 1, Color.WHITE);
    createButton("5", 1, 4, 1, 1, Color.WHITE);
    createButton("6", 2, 4, 1, 1, Color.WHITE);
    createButton("*", 3, 4, 1, 1, Color.LIGHTBLUE);
    createButton("1/x", 4, 4, 1, 1, Color.LIGHTBLUE);

    createButton("1", 0, 5, 1, 1, Color.WHITE);
    createButton("2", 1, 5, 1, 1, Color.WHITE);
    createButton("3", 2, 5, 1, 1, Color.WHITE);
    createButton("-", 3, 5, 1, 1, Color.LIGHTBLUE);

    createButton("0", 0, 6, 2, 1, Color.WHITE);
    createButton(".", 2, 6, 1, 1, Color.WHITE);
    createButton("+", 3, 6, 1, 1, Color.LIGHTBLUE);

    createButton("=", 4, 5, 1, 2, Color.LIGHTBLUE);

    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
