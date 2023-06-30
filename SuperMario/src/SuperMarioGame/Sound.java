package SuperMarioGame;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
 
    private final MediaPlayer jumpSound;
    private final MediaPlayer mainSound;
    private final MediaPlayer gameOverSound;
    private final MediaPlayer endGameSound;
    public Sound() {
        // import main Game Sound
        File Sound1File = new File("src/Sounds/GroundTheme.mp3");
        mainSound = new MediaPlayer(new Media(Sound1File.toURI().toString()));
        mainSound.setCycleCount(MediaPlayer.INDEFINITE);
        // import main Jump Sound
        File Sound2File = new File("src/Sounds/Jump.mp3");
        jumpSound = new MediaPlayer(new Media(Sound2File.toURI().toString()));
        // import GameOver Sound
        File Sound3File = new File("src/Sounds/GameOver.mp3");
        gameOverSound = new MediaPlayer(new Media(Sound3File.toURI().toString()));
        // import EndGame Sound
        File Sound4File = new File("src/Sounds/final.wav");
        endGameSound = new MediaPlayer(new Media(Sound4File.toURI().toString()));
    }
    // function to play jump Sound
    public MediaPlayer getJumpSound() {
        return jumpSound;
    }
    public MediaPlayer getMainSound() {
        return mainSound;
    }
    public MediaPlayer getGameOverSound() {
        return gameOverSound;
    }
    public MediaPlayer getEndGameSound() {
        return endGameSound;
    }
   
}
