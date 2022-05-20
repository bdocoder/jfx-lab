import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Lab1 extends Application {

  Font textFont = new Font(16);

  @Override
  public void start(Stage stage) {
    GridPane gp = new GridPane();

    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        // from 0 to 7 are the squares
        // 8 is the text
        if (row == 8 ^ col == 8) {
          char c = (row < 8 ? "12345678".charAt(row) : "ABCDEFGH".charAt(col));
          Text text = new Text(c + "");
          text.setFont(textFont);
          gp.add(text, col, row);
          continue;
        }
        // every time the row or col changes,
        // the color gets flipped between black and white
        Color c = ((row + (col % 2)) % 2 == 0) ? Color.WHITE : Color.BLACK;
        Rectangle rect = new Rectangle(64, 64);
        rect.setFill(c);
        gp.add(rect, col, row);
      }
    }
    Scene scene = new Scene(gp, 576, 576);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
