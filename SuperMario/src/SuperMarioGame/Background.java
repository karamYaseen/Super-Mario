package SuperMarioGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Background extends Pane {

    public Background() {
        Image bground = new Image("Images/background.png");
        Image egame = new Image("Images/endgame.png");
        int Num_of_Frames = 20;
        ImageView[] btn = new ImageView[Num_of_Frames];
        for (int i = 0; i <= Num_of_Frames - 1; i++) {
            if(i ==  Num_of_Frames - 1){
                btn[i] = new ImageView(egame);
                btn[i].setLayoutX(btn[i-1].getLayoutX()+1350);
                super.getChildren().add(btn[i]);
            }
            btn[i] = new ImageView(bground);
            btn[i].setLayoutX(-200 + 500 * i);
            super.getChildren().add(btn[i]);
        }
    }
}
