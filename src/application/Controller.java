package application;

import java.io.IOException;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button button1;

    @FXML
    private BorderPane borderPaneMain;

    @FXML
    private void onClick(ActionEvent event) throws IOException {
        System.out.println("Clicked");
        WorkSpace ws = new WorkSpace();
        ws.show();
    }
}