package SuperMarioGame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class GameOver extends Pane {
    Button tryAgain_Button;
    Button Exit2_Button;

    public GameOver() {
        // Load the game over image
        Image gameover = new Image("Images/GameOver.png");
        ImageView gameoverImg = new ImageView(gameover);

        // Create the "Try Again" button
        tryAgain_Button = new Button("Try Again");
        tryAgain_Button.setStyle("-fx-font: 18 arial; -fx-base: #ffa202;-fx-font-weight : bold;");
        tryAgain_Button.setPrefWidth(130);

        // Create the "Exit" button
        Exit2_Button = new Button("Exit");
        Exit2_Button.setPrefWidth(130);
        Exit2_Button.setStyle("-fx-font: 18 arial; -fx-base: #9c3318;-fx-font-weight : bold;");

        // Create an HBox to hold the game over buttons
        HBox gameoverButtons = new HBox(50);
        gameoverButtons.setPadding(new Insets(380, 10, 100, 360));
        gameoverButtons.getChildren().addAll(tryAgain_Button, Exit2_Button);

        // Add the game over image and buttons to the pane
        super.getChildren().addAll(gameoverImg, gameoverButtons);
    }
}
