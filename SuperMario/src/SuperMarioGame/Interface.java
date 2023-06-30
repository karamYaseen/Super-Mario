package SuperMarioGame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Interface extends StackPane {
    Button Start_Button;
    Button Exit_Button;
    ImageView startImg;
    Button Mute_Button;
    Label scoreLabel;

    public Interface() {
        // Load the start image
        Image Pic = new Image("Images/start.png");
        startImg = new ImageView(Pic);

        // Button to start the game
        Start_Button = new Button("Start Game");
        Start_Button.setPrefWidth(180);
        Start_Button.setStyle("-fx-font: 18 arial; -fx-base: #08f000;-fx-font-weight : bold;");

        // Button to exit the game
        Exit_Button = new Button("Exit");
        Exit_Button.setPrefWidth(130);
        Exit_Button.setStyle("-fx-font: 18 arial; -fx-base: #f70202;-fx-font-weight : bold");

        // Button to mute the music
        Mute_Button = new Button("Mute Music");
        Mute_Button.setStyle("-fx-font: 18 arial; -fx-base: #efd814;-fx-font-weight : bold;");

        // Label to display the score
        scoreLabel = new Label("Coins: " + "0");
        scoreLabel.setStyle("-fx-font-size: 22; -fx-text-fill: brown; -fx-font-weight : bold; -fx-background-color :#f8e16c; -fx-background-radius : 5px");
        scoreLabel.setVisible(false);
        scoreLabel.setTranslateX(5);
        scoreLabel.setTranslateY(20);
        Mute_Button.setTranslateY(30);

        // Create an HBox for the top section of the interface, containing the score label and mute button
        HBox Top = new HBox(750);
        Top.getChildren().addAll(scoreLabel, Mute_Button);

        // Create a VBox for the game buttons, containing the start button and exit button
        VBox GameButtons = new VBox(10);
        GameButtons.getChildren().addAll(Start_Button, Exit_Button);
        GameButtons.setAlignment(Pos.CENTER);
        GameButtons.setPadding(new Insets(400, 10, 80, 500));

        // Create a BorderPane to organize the layout, with the game buttons at the bottom and top section on the top
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(GameButtons);
        borderPane.setTop(Top);

        // Add the start image and the borderPane to the stack pane
        super.getChildren().addAll(startImg, borderPane);
    }
}
