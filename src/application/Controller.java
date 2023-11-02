package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button button1;
    private int n;

    @FXML
    protected void onClick(ActionEvent event) throws Exception {
        // n++;
        // button1.setText("Нажата кнопка " + n + " раз.");
        System.out.println(button1);
    }
}