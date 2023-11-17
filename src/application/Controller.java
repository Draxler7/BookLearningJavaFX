package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

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
        Main.closeWindow();
    }
}