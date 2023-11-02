package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
    private Button button1;
    private String primaryStage;

    @FXML
    public void onClick(ActionEvent event) throws Exception {
        System.out.println("1 sec");
    }
}