package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {
    private ImageView audi;

    public Images() throws FileNotFoundException {
        Image img1 = new Image(new FileInputStream("bin\\img\\cars\\audi (sedan).png"));
        this.audi.setImage(img1);
    }

    public ImageView getAudi() {
        return this.audi;
    }
}
