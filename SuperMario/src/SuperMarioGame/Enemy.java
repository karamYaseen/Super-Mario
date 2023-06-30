package SuperMarioGame;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Enemy extends StackPane {
    List<ImageView> enemies;
    Timeline EnemyGeneration;
    Timeline EnemyMovement;

    public Enemy() {
        enemies = new ArrayList<>();

        // Enemy generation timeline
        EnemyGeneration = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
            ImageView enemyPhoto = new ImageView(new Image("Images/enemy1.png")); // Load the enemy image
            enemyPhoto.setTranslateX(600);
            enemyPhoto.setTranslateY(175);
            enemies.add(enemyPhoto);
            super.getChildren().add(enemyPhoto);
        }));

        // Enemy movement timeline
        EnemyMovement = new Timeline(new KeyFrame(Duration.millis(40), e -> {
            for (ImageView enemy : enemies) {
                enemy.setTranslateX(enemy.getTranslateX() - 10); // Move the enemy to the left
            }
        }));

        EnemyGeneration.setCycleCount(Animation.INDEFINITE); // Repeat indefinitely
        EnemyMovement.setCycleCount(Animation.INDEFINITE); // Repeat indefinitely
    }

    // Start generating and moving enemies
    public void generateEnemies() {
        EnemyGeneration.play();
        EnemyMovement.play();
    }

    // Stop generating and moving enemies
    public void stopGenerateEnemies() {
        EnemyGeneration.stop();
        EnemyMovement.stop();
    }
}

