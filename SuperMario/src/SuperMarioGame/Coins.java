package SuperMarioGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Coins extends StackPane {
    List<ImageView> coins; // List to store the ImageView objects representing coins
    private Timeline coinMovement; // Timeline for coin movement animation
    private Timeline coinGeneration; // Timeline for coin generation

    public Coins() {
        coins = new ArrayList<>(); // Initialize the list of coins
        Random random = new Random(); // Create a Random object for randomization
        coinGeneration = new Timeline(new KeyFrame(Duration.seconds(4), e -> {
            ImageView coinPhoto = new ImageView(new Image("Images/boxCoin0.png")); // Create a new ImageView for the coin image
            coinPhoto.setTranslateX(600); // Set the initial X translation of the coin
            coinPhoto.setTranslateY(150 - random.nextInt(130)); // Set the initial Y translation of the coin with random variation
            coins.add(coinPhoto); // Add the coin ImageView to the list
            super.getChildren().add(coinPhoto); // Add the coin ImageView to the StackPane
        }));
        coinMovement = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            for (ImageView coin : coins) {
                coin.setTranslateX(coin.getTranslateX() - 10); // Move the coin to the left by decreasing its X translation
            }
        }));
        coinGeneration.setCycleCount(Animation.INDEFINITE); // Set the generation animation to repeat indefinitely
        coinMovement.setCycleCount(Animation.INDEFINITE); // Set the movement animation to repeat indefinitely
    }

    public void generateCoins() {
        coinGeneration.play(); // Start the coin generation animation
        coinMovement.play(); // Start the coin movement animation
    }

    public void stopGenerateCoins() {
        coinGeneration.stop(); // Stop the coin generation animation
        coinMovement.stop(); // Stop the coin movement animation
    }
}
