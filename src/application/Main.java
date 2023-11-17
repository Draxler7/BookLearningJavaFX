package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage primaryStage;

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Image icon = new Image(new FileInputStream("bin\\img\\pngwing.com (10).png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Стартовое окно \"Kuromi washing\"");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

    public static void closeWindow() {
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
