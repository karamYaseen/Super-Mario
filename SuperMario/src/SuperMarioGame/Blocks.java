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

public class Blocks extends StackPane {
    List<ImageView> blocks; 
    private Timeline blockMovement; 
    private Timeline blockGeneration; 

    public Blocks() {
        blocks = new ArrayList<>(); // Initialize the list of blocks
        Random random = new Random(); // Create a Random object for randomization
        blockGeneration = new Timeline(new KeyFrame(Duration.seconds(9), e -> {
            ImageView blockPhoto = new ImageView(new Image("Images/block.png")); // Create a new ImageView for the block image
            blockPhoto.setTranslateX(600); // Set the initial X translation of the block
            blockPhoto.setTranslateY(150 - random.nextInt(100)); // Set the initial Y translation of the block with random variation
            blocks.add(blockPhoto); // Add the block ImageView to the list
            super.getChildren().add(blockPhoto); // Add the block ImageView to the StackPane
        }));
        blockMovement = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            for (ImageView block : blocks) {
                block.setTranslateX(block.getTranslateX() - 10); // Move the block to the left by decreasing its X translation
            }
        }));
        blockGeneration.setCycleCount(Animation.INDEFINITE); // Set the generation animation to repeat indefinitely
        blockMovement.setCycleCount(Animation.INDEFINITE); // Set the movement animation to repeat indefinitely
    }

    public void generateBlocks() {
        blockGeneration.play(); // Start the block generation animation
        blockMovement.play(); // Start the block movement animation
    }

    public void stopGenerateBlocks() {
        blockGeneration.stop(); // Stop the block generation animation
        blockMovement.stop(); // Stop the block movement animation
    } 
}
