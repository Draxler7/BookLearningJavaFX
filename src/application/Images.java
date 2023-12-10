package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Images {
    // private static ImageView audi;
    // private static ImageView bmw;
    // private static ImageView mercedes;
    // private static ImageView toyota;

    // private static ImageView audiDirt;
    // private static ImageView bmwDirt;
    // private static ImageView mercedesDirt;
    // private static ImageView toyotaDirt;
    static Image img1;
    static Image img2;
    static Image img3;
    static Image img4;
    Image img5;
    Image img6;
    Image img7;
    Image img8;

    public Images() throws FileNotFoundException {
        img1 = new Image(new FileInputStream("bin\\img\\cars\\audi (sedan).png"));
        img2 = new Image(new FileInputStream("bin\\img\\cars\\bmw (super car).png"));
        img3 = new Image(new FileInputStream("bin\\img\\cars\\mercedes (cabriolet).png"));
        img4 = new Image(new FileInputStream("bin\\img\\cars\\toyota (jeep).png"));
        // audi.setImage(img1);
        // bmw.setImage(img2);
        // mercedes.setImage(img3);
        // toyota.setImage(img4);

        img5 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty audi (sedan).png"));
        img6 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty bmw (super car).png"));
        img7 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty mercedes (cabriolet).png"));
        img8 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty toyota (jeep).png"));

        // audiDirt.setImage(img5);
        // bmwDirt.setImage(img6);
        // mercedesDirt.setImage(img7);
        // toyotaDirt.setImage(img8);
    }

    public Image getAudi() {
        return img1;
    }

    public static Image getMerc() {
        return img2;
    }

    public static Image getBmw() {
        return img3;
    }

    public static Image getToyo() {
        return img4;
    }

}
