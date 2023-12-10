package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ControllerWS {

    @FXML
    private TextArea statA1, statA2, statA3, statA4, statA5, statA6, statA7, statA8,
            statA9;

    @FXML
    private ProgressBar pb1, pb2, pb3, pb4, pb5, pb6, pb7, pb8, pb9;

    @FXML
    private Button btn1, btn2, btn3, btn4, btn5;

    @FXML
    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;

    @FXML
    private TextArea typeA1, typeA2, typeA3, typeA4, typeA5, typeA6, typeA7, typeA8,
            typeA9;

    @FXML
    private ProgressIndicator speedPena, speedWater;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField textMessage;

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
    private boolean setCrash1 = false;
    private boolean setCrash2 = false;

    private static double pena;
    private static double water;

    @FXML
    void crash1() {
        isStarted = false;
        setCrash1 = true;
        new Thread(() -> {
            while (setCrash1) {
                textMessage.setText("Электричество отключено");
                textMessage.setStyle("-fx-text-fill: red;");
                borderPane.setBackground(Background.fill(Color.RED));
                System.out.println("Электричество отключено!!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                borderPane.setBackground(Background.fill(Color.BLACK));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @FXML
    void crash2() {
        isStarted = false;
        setCrash2 = true;
        new Thread(() -> {
            while (setCrash2) {
                textMessage.setText("Оборудование неисправно");
                textMessage.setStyle("-fx-text-fill: red;");
                borderPane.setBackground(Background.fill(Color.BLUE));
                System.out.println("Оборудование неисправно!!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                borderPane.setBackground(Background.fill(Color.BLACK));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @FXML
    void fix() {
        textMessage.setText("Все прекрасно");
        textMessage.setStyle("-fx-text-fill: green;");
        setCrash1 = false;
        setCrash2 = false;
        isStarted = true;
        borderPane.setStyle("-fx-background-color:  linear-gradient(to bottom right, #FF0000, #0000FF);");
    }

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
                    Thread.sleep(stopTime * 900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned1)) {
                    isRunned1 = true;
                    int carChoose = rndNum(1, 4);
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

        new Thread(() -> {// 2 мойка
            while (true) {
                statA2.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 913);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned2)) {
                    isRunned2 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv2.setImage(img5);
                            workMachine(statA2, typeA2, pb2, iv2, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv2.setImage(img6);
                            workMachine(statA2, typeA2, pb2, iv2, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv2.setImage(img7);
                            workMachine(statA2, typeA2, pb2, iv2, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv2.setImage(img8);
                            workMachine(statA2, typeA2, pb2, iv2, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned2 = false;
                }
            }
        }).start();

        new Thread(() -> {// 3 мойка
            while (true) {
                statA3.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 931);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned3)) {
                    isRunned3 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv3.setImage(img5);
                            workMachine(statA3, typeA3, pb3, iv3, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv3.setImage(img6);
                            workMachine(statA3, typeA3, pb3, iv3, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv3.setImage(img7);
                            workMachine(statA3, typeA3, pb3, iv3, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv3.setImage(img8);
                            workMachine(statA3, typeA3, pb3, iv3, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned3 = false;
                }
            }
        }).start();

        new Thread(() -> {// 4 мойка
            while (true) {
                statA4.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 945);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned4)) {
                    isRunned4 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv4.setImage(img5);
                            workMachine(statA4, typeA4, pb4, iv4, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv4.setImage(img6);
                            workMachine(statA4, typeA4, pb4, iv4, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv4.setImage(img7);
                            workMachine(statA4, typeA4, pb4, iv4, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv4.setImage(img8);
                            workMachine(statA4, typeA4, pb4, iv4, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned4 = false;
                }
            }
        }).start();

        new Thread(() -> {// 5 мойка
            while (true) {
                statA5.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 969);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned5)) {
                    isRunned5 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv5.setImage(img5);
                            workMachine(statA5, typeA5, pb5, iv5, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv5.setImage(img6);
                            workMachine(statA5, typeA5, pb5, iv5, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv5.setImage(img7);
                            workMachine(statA5, typeA5, pb5, iv5, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv5.setImage(img8);
                            workMachine(statA5, typeA5, pb5, iv5, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned5 = false;
                }
            }
        }).start();

        new Thread(() -> {// 6 мойка
            while (true) {
                statA6.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 962);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned6)) {
                    isRunned6 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv6.setImage(img5);
                            workMachine(statA6, typeA6, pb6, iv6, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv6.setImage(img6);
                            workMachine(statA6, typeA6, pb6, iv6, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv6.setImage(img7);
                            workMachine(statA6, typeA6, pb6, iv6, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv6.setImage(img8);
                            workMachine(statA6, typeA6, pb6, iv6, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned6 = false;
                }
            }
        }).start();

        new Thread(() -> {// 7 мойка
            while (true) {
                statA7.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned7)) {
                    isRunned7 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv7.setImage(img5);
                            workMachine(statA7, typeA7, pb7, iv7, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv7.setImage(img6);
                            workMachine(statA7, typeA7, pb7, iv7, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv7.setImage(img7);
                            workMachine(statA7, typeA7, pb7, iv7, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv7.setImage(img8);
                            workMachine(statA7, typeA7, pb7, iv7, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned7 = false;
                }
            }
        }).start();

        new Thread(() -> {// 8 мойка
            while (true) {
                statA8.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 988);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned8)) {
                    isRunned8 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv8.setImage(img5);
                            workMachine(statA8, typeA8, pb8, iv8, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv8.setImage(img6);
                            workMachine(statA8, typeA8, pb8, iv8, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv8.setImage(img7);
                            workMachine(statA8, typeA8, pb8, iv8, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv8.setImage(img8);
                            workMachine(statA8, typeA8, pb8, iv8, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned8 = false;
                }
            }
        }).start();

        new Thread(() -> {// 9 мойка
            while (true) {
                statA9.setText("Ожидание машины");
                int stopTime = rndNum(2, 6);
                try {
                    Thread.sleep(stopTime * 994);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((isStarted) && (!isRunned9)) {
                    isRunned9 = true;
                    int carChoose = rndNum(1, 4);
                    switch (carChoose) {
                        case 1: {
                            iv9.setImage(img5);
                            workMachine(statA9, typeA9, pb9, iv9, img1, "Седан");
                            break;
                        }
                        case 2: {
                            iv9.setImage(img6);
                            workMachine(statA9, typeA9, pb9, iv9, img2, "Супер кар");
                            break;
                        }
                        case 3: {
                            iv9.setImage(img7);
                            workMachine(statA9, typeA9, pb9, iv9, img3, "Кабриолет");
                            break;
                        }
                        case 4: {
                            iv9.setImage(img8);
                            workMachine(statA9, typeA9, pb9, iv9, img4, "Джип");
                            break;
                        }
                        default:
                            break;
                    }
                    isRunned9 = false;
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
        setPena(20);
        for (double i = 0; i <= 0.25; i += 0.01) {
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
        setPena(-20);
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
        setWater(20);
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
        setWater(-20);
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

    public void setCharts() {

        new Thread(() -> {

            while (true) {
                speedPena.setProgress(0.25 + pena * 0.001);
                speedWater.setProgress(0.25 + water * 0.001);
                if (speedPena.getProgress() > 0.6)
                    speedPena.setBackground(Background.fill(Color.RED));
                else
                    speedPena.setBackground(Background.fill(new Color(0.71, 1, 0.7, 0)));
            }
        }).start();
    }

    public static void setPena(double x) {
        pena = pena + x;
    }

    public static double getPena() {
        return pena;
    }

    public static void setWater(double y) {
        water = water + y;
    }

    public static double getWater() {
        return water;
    }

}