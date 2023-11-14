package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WorkSpace extends Stage {

    public WorkSpace() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WorkSpace.fxml"));
        setScene(new Scene(root, 1000, 600));
        setTitle("Kuromi Washing");
        Image icon = new Image(new FileInputStream("bin\\img\\pngwing.com (10).png"));
        getIcons().add(icon);
        show();
    }

}
