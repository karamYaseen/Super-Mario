package SuperMarioGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EndGame extends Pane {
    Button newGame_Button;
    Button Exit3_Button;

    public EndGame() {
        Image endGame = new Image("Images/congrats.png"); // Load the end game image
        ImageView endgameimg = new ImageView(endGame); // Create an ImageView to display the end game image

        newGame_Button = new Button("Main Menu"); // Create a button for the main menu
        newGame_Button.setStyle("-fx-font: 18 arial; -fx-base: #fec601;-fx-font-weight : bold;"); // Set the style of the button
        newGame_Button.setPrefWidth(180); // Set the preferred width of the button

        Exit3_Button = new Button("Exit"); // Create a button for exiting the game
        Exit3_Button.setPrefWidth(120); // Set the preferred width of the button
        Exit3_Button.setStyle("-fx-font: 18 arial; -fx-base: #940101;-fx-font-weight : bold;"); // Set the style of the button

        VBox endgameButtonsBox = new VBox(20); // Create a VBox to hold the end game buttons
        endgameButtonsBox.setPadding(new Insets(370, 10, 100, 440)); // Set the padding of the VBox
        endgameButtonsBox.setAlignment(Pos.CENTER); // Center align the VBox
        endgameButtonsBox.getChildren().addAll(newGame_Button, Exit3_Button); // Add the buttons to the VBox

        super.getChildren().addAll(endgameimg, endgameButtonsBox); // Add the end game image and the buttons to the Pane
    }
}
