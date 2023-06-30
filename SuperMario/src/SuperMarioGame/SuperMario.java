package SuperMarioGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SuperMario extends Application {
    private int scoreCounter = 0;
    private boolean soundFlag = true;
    // Create Background
    Background backGround = new Background();
    // Create Interface Page
    Interface Inter = new Interface();
    // Create Mario character
    Player mario = new Player();
    // Create Blocks
    Blocks blocks = new Blocks();
    // Create Enemies
    Enemy enemies = new Enemy();
    // Create Coins
    Coins coins = new Coins();
    // Create GameOver Page
    GameOver gameover = new GameOver();
    // Create EndGame Page
    EndGame endgame = new EndGame();
    // Create game sound
    Sound gameSound = new Sound();
    // Create Main Pane
    StackPane screen = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        // Handling Interface Buttons
        Inter.Start_Button.setOnAction(e -> {
            // Hide the interface buttons and start the game elements
            Inter.Start_Button.setVisible(false);
            Inter.Exit_Button.setVisible(false);
            Inter.startImg.setVisible(false);
            Inter.scoreLabel.setVisible(true);
            screen.requestFocus();
            mario.playJumpingMario();
            blocks.generateBlocks();
            coins.generateCoins();
            enemies.generateEnemies();
            if (soundFlag) {
                gameSound.getJumpSound().play();
            } else {
                gameSound.getJumpSound().stop();
            }
        });

        Inter.Exit_Button.setOnAction(e -> {
            primaryStage.close();
        });

        Inter.Mute_Button.setOnAction(e -> {
            // Toggle the game sound on/off
            if (soundFlag) {
                Inter.Mute_Button.setText("Unmute Music");
                soundFlag = false;
                gameSound.getMainSound().pause();
                gameSound.getJumpSound().stop();
            } else {
                Inter.Mute_Button.setText("Mute Music");
                soundFlag = true;
                gameSound.getMainSound().play();
            }
            screen.requestFocus();
        });

        /************************************************/
        // Handling Screen Actions
        screen.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                // Move Mario character to the right
                mario.playMovingMario();
                backGround.setTranslateX(backGround.getTranslateX() - 10);
                // Check for collision with the end of the game
                if (backGround.getTranslateX() == -9940) {
                    endgame.setVisible(true);
                    if (soundFlag) {
                        gameSound.getJumpSound().stop();
                        gameSound.getMainSound().stop();
                        gameSound.getEndGameSound().play();
                    } else {
                        gameSound.getEndGameSound().stop();
                    }
                }
                // Check for collision with coins
                for (ImageView coin : coins.coins) {
                    if (coin.getTranslateX() == mario.getTranslateX()) {
                        // Increment the score by one when Mario collides with coins
                        Inter.scoreLabel.setText("Score: " + (++scoreCounter));
                        coin.setVisible(false);
                    }
                }
                // Check for collision with enemies
                for (ImageView enemy : enemies.enemies) {
                    if (enemy.getTranslateX() == mario.getTranslateX()) {
                        gameover.requestFocus();
                        gameover.setVisible(true);
                        blocks.stopGenerateBlocks();
                        enemies.stopGenerateEnemies();
                        coins.stopGenerateCoins();
                        gameSound.getMainSound().stop();
                        gameSound.getJumpSound().stop();
                        if (soundFlag) {
                            gameSound.getGameOverSound().play();
                        } else {
                            gameSound.getGameOverSound().stop();
                        }
                    }
                }
            }
            if (e.getCode() == KeyCode.SPACE) {
                // Make Mario character jump
                mario.playJumpingMario();
                if (soundFlag) {
                    gameSound.getJumpSound().stop();
                    gameSound.getJumpSound().play();
                } else {
                    gameSound.getJumpSound().stop();
                }
            }
        });
        screen.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                // Stop Mario character from moving
                mario.stopMovingMario();
            }
        });
        /***************************************************/
        // Handling GameOver Screen Buttons
        gameover.tryAgain_Button.setOnAction(e -> {
            // Reset the game and score when "Try Again" button is clicked
            Inter.scoreLabel.setText("Coins: 0");
            scoreCounter = 0;
            gameover.setVisible(false);
            screen.requestFocus();
            mario.playJumpingMario();
            blocks.generateBlocks();
            enemies.generateEnemies();
            coins.generateCoins();
            gameSound.getGameOverSound().stop();
            if (soundFlag) {
                gameSound.getMainSound().play();
                gameSound.getJumpSound().play();
            } else {
                gameSound.getJumpSound().stop();
                gameSound.getMainSound().stop();
            }
        });
        gameover.Exit2_Button.setOnAction(e -> {
            primaryStage.close();
        });
        /***************************************************/
        // Handling EndGame Screen Buttons
        endgame.newGame_Button.setOnAction(e -> {
            // Restart the game when "New Game" button is clicked
            primaryStage.close();
            this.restartPrimaryStage(primaryStage);
        });

        endgame.Exit3_Button.setOnAction(e -> {
            primaryStage.close();
        });
        /***************************************************/
        // Initial Instructions
        gameSound.getMainSound().play();
        gameover.setVisible(false);
        endgame.setVisible(false);
        Inter.requestFocus();
        /***************************************************/
        // Adding Elements to Pane
        screen.getChildren().addAll(backGround, blocks, enemies, coins, mario, Inter, gameover, endgame);
        Scene scene = new Scene(screen, 1000, 550);
        primaryStage.setTitle("Super Mario");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(false);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("Images/Mario_Ico.png"));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void restartPrimaryStage(Stage primaryStage) {
        // Restart the application by creating a new stage and launching the game
        primaryStage = new Stage();
        Platform.runLater(() -> {
            new SuperMario().start(new Stage());
        });
    }
}
