package SuperMarioGame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Player extends Pane {
    // Index of the current image being displayed
    private int imageIndex = 0;
    // Y-coordinate of the ground level
    private static final int GROUND_Y = 250;
    // Vertical velocity of the player character during jumping
    private int playerVelocityY;
    // Indicates if the player is currently jumping
    private boolean isJumping = false;
    // Animation timeline for the jumping Mario character
    private final Timeline tim_JumpingMario;
    // Animation timeline for the moving Mario character
    private final Timeline tim_MovingMario;
    public Player() {
        // Create ImageViews for the two images of Mario character
        Image pic1 = new Image("Images/superUp.png");
        ImageView img1 = new ImageView(pic1);
        Image pic2 = new Image("Images/superDown.png");
        ImageView img2 = new ImageView(pic2);
        // Create a Pane to hold the Mario character
        Pane MarioChar = new Pane();
        MarioChar.setLayoutX(200);
        MarioChar.setLayoutY(GROUND_Y);
        MarioChar.getChildren().addAll(img1, img2);
        // Set the visibility of the images
        img1.setVisible(false);
        // Create a timeline for switching between the two images
        tim_MovingMario = new Timeline(new KeyFrame(Duration.millis(120), e -> {
            if (imageIndex == 0) {
                img1.setVisible(false);
                img2.setVisible(true);
                imageIndex = 1;
            } else {
                img1.setVisible(true);
                img2.setVisible(false);
                imageIndex = 0;
            }
        }));
        tim_MovingMario.setCycleCount(Animation.INDEFINITE);
        // Create a timeline for handling the jumping animation
        tim_JumpingMario = new Timeline(new KeyFrame(Duration.millis(13), event -> {
            // Update the player's position based on the jump velocity
            playerVelocityY += 1; // Increase the player's Y velocity
            MarioChar.setLayoutY(MarioChar.getLayoutY() + playerVelocityY); // Move the player vertically
            if (MarioChar.getLayoutY() >= GROUND_Y) {
                // Stop the jump animation when the player hits the ground
                MarioChar.setLayoutY(GROUND_Y);
                isJumping = false;
            }
        }));
        tim_JumpingMario.setCycleCount(Animation.INDEFINITE);
        // Add the Mario character to the pane
        super.getChildren().add(MarioChar);
    }
    // Start the jumping animation
    public void playJumpingMario() {
        if (!isJumping) {
            playerVelocityY = -23;
            tim_JumpingMario.play();
            isJumping = true;
        }
    }
    // Stop the jumping animation
    public void stopJumpingMario() {
        tim_JumpingMario.stop();
    }
    // Start the moving animation
    public void playMovingMario() {
        tim_MovingMario.play();
    }
    // Stop the moving animation
    public void stopMovingMario() {
        tim_MovingMario.stop();
    }
    // Get the timeline for the jumping animation
    public Timeline getTim_JumpingMario() {
        return tim_JumpingMario;
    }
    // Get the timeline for the moving animation
    public Timeline getTim_MovingMario() {
        return tim_MovingMario;
    }
}
