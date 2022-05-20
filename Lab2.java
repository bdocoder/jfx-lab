import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Lab2 extends Application {

    double spacing = 10;

    @Override
    public void start(Stage stage) {
        TextField tf = new TextField();

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        submitButton.setOnMouseClicked(e -> System.out.println(tf.getText()));
        cancelButton.setOnMouseClicked(e -> stage.close());

        HBox hBox = new HBox(submitButton, cancelButton);
        VBox vBox = new VBox(tf, hBox);

        hBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(spacing);
        hBox.setSpacing(spacing);
        vBox.setPadding(new Insets(spacing * 2));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
