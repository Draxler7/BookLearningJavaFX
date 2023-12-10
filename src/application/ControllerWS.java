package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class ControllerWS {

    @FXML
    private BorderPane borderPane1, borderPane2, borderPane3, borderPane4, borderPane5, borderPane6, borderPane7,
            borderPane8, borderPane9;

    @FXML
    private TextArea statA1, statA2, statA3, statA4, statA5, statA6, statA7, statA8,
            statA9;

    @FXML
    private ProgressBar pb1, pb2, pb3, pb4, pb5, pb6, pb7, pb8, pb9;

    @FXML
    private StackPane stackPane1, stackPane2, stackPane3, stackPane4, stackPane5, stackPane6, stackPane7, stackPane8,
            stackPane9;

    @FXML
    private Button btn1, btn2, btn3, btn4;

    @FXML
    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;

    @FXML
    private TextArea typeA1, typeA2, typeA3, typeA4, typeA5, typeA6, typeA7, typeA8,
            typeA9;

    @FXML
    private static BorderPane chartPane;

    static Image img1;
    static Image img2;
    static Image img3;
    static Image img4;
    static Image img5;
    static Image img6;
    static Image img7;
    static Image img8;

    private static boolean isStarted = false;
    private static boolean isRunned1 = false, isRunned2 = false, isRunned3 = false, isRunned4 = false,
            isRunned5 = false, isRunned6 = false, isRunned7 = false, isRunned8 = false, isRunned9 = false;

    private static double pena;
    private double water;

    @FXML
    void onStartTrue() {
        isStarted = true;
    }

    @FXML
    void onStartFalse() {
        isStarted = false;
    }

    @FXML
    void initialize() throws FileNotFoundException {

        imagesSets();

        setCharts();

        new Thread(() -> {// 1 мойка
            while (true) {
                statA1.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned1)) {
                    isRunned1 = true;
                    int carChoose = rndNum(1, 4);
                    System.out.print(carChoose);
                    switch (carChoose) {
                        case 1: {
                            iv1.setImage(img5);
                            workMachine(statA1, typeA1, pb1, iv1, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv1.setImage(img6);
                            workMachine(statA1, typeA1, pb1, iv1, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv1.setImage(img7);
                            workMachine(statA1, typeA1, pb1, iv1, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv1.setImage(img8);
                            workMachine(statA1, typeA1, pb1, iv1, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned1 = false;
                }
            }
        }).start();
    }

    public static int rndNum(int x, int y) {
        return (int) ((Math.random() * ((y - x) + 1)) + x);
    }

    public static void imagesSets() throws FileNotFoundException {
        img1 = new Image(new FileInputStream("bin\\img\\cars\\audi (sedan).png"));
        img2 = new Image(new FileInputStream("bin\\img\\cars\\bmw (super car).png"));
        img3 = new Image(new FileInputStream("bin\\img\\cars\\mercedes (cabriolet).png"));
        img4 = new Image(new FileInputStream("bin\\img\\cars\\toyota (jeep).png"));
        img5 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty audi (sedan).png"));
        img6 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty bmw (super car).png"));
        img7 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty mercedes (cabriolet).png"));
        img8 = new Image(new FileInputStream("bin\\img\\cars\\dirty\\dirty toyota (jeep).png"));
    }

    public static void workMachine(TextArea statA, TextArea typeA, ProgressBar pb, ImageView iv, Image img,
            String str) {
        statA.setText("Работа Пеногенератора");
        typeA.setText("Тип машины: " + str);
        for (double i = 0; i <= 0.25; i += 0.01) {
            pb.setProgress(i);
            setPena(20);
            while (!isStarted) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setPena(-20);
        }
        statA.setText("Работа Моющего пистолета");
        for (double i = 0.25; i <= 0.5; i += 0.01) {
            pb.setProgress(i);
            while (!isStarted) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        statA.setText("Работа Водяного насоса");
        for (double i = 0.5; i <= 0.75; i += 0.01) {
            pb.setProgress(i);
            while (!isStarted) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        statA.setText("Работа Воздушного компрессора");
        for (double i = 0.75; i <= 1; i += 0.01) {
            pb.setProgress(i);
            while (!isStarted) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        iv.setImage(null);
        iv.setImage(img);
        statA.setText("Мойка завершена!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        iv.setImage(null);
        typeA.setText(null);
        pb.setProgress(0);
    }

    public static void setCharts() {

        final NumberAxis xAxis = new NumberAxis(1, 50, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number, Number> ac = new AreaChart<>(xAxis, yAxis);
        ac.setTitle("Затраты Пены");
        chartPane.setLeft(ac);
        new Thread(() -> {

            XYChart.Series series1 = new XYChart.Series();

            for (int i = 0; i <= 60; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                series1.getData().add(new XYChart.Data(getPena(), i));
                ac.getData().addAll(series1);
            }
        }).start();
    }

    public static void setPena(double x) {
        pena = pena + x;
    }

    public static double getPena() {
        return pena;
    }

}