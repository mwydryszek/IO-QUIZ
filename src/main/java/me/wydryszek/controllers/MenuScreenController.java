package me.wydryszek.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import me.wydryszek.quiz.Parametry;

import java.io.IOException;


public class MenuScreenController {

    private StackPaneController stackPaneController;
    protected static Parametry par = new Parametry();


    @FXML
    private CheckBox ColorCheckBox;
    @FXML
    private CheckBox LosCheckBox;
    @FXML
    private CheckBox TimerCheckBox;
    @FXML
    private ColorPicker GetColor;
    @FXML
    private Pane MenuPane;

    @FXML
    public void changeColor() {
        if (ColorCheckBox.isSelected()) {
            par.setCzyKolor(true);
            stackPaneController.mainStackPane.setStyle("-fx-background-color: #" + colorToHex(GetColor.getValue()) + ";");
            MenuPane.setStyle(stackPaneController.mainStackPane.getStyle());
        } else {
            par.setCzyKolor(false);
            MenuPane.setStyle("-fx-background-color: #f0f0f0;");
            stackPaneController.mainStackPane.setStyle("-fx-background-color: #f0f0f0;");
        }
    }

    @FXML
    public void losujPytania() {
        if (LosCheckBox.isSelected()) {
            par.setCzyLosowac(true);
        } else {
            par.setCzyLosowac(false);
        }

    }

    @FXML
    public void timerOn() {
        if (TimerCheckBox.isSelected()) {
            par.setCzyTimer(true);
        } else {
            par.setCzyTimer(false);
        }
    }

    @FXML
    public void startQuiz() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/QuizScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        QuizController quizController = loader.getController();
        quizController.setStackPaneController(stackPaneController);
        stackPaneController.setScreen(pane);
    }


    public void checkLoad() {

        if (par.getCzyKolor())
            ColorCheckBox.setSelected(true);
        else
            ColorCheckBox.setSelected(false);

        if (par.getCzyLosowac())
            LosCheckBox.setSelected(true);
        else
            LosCheckBox.setSelected(false);

        if (par.getCzyTimer())
            TimerCheckBox.setSelected(true);
        else
            TimerCheckBox.setSelected(false);

    }

    public static String colorToHex(Color color) {
        return colorChanelToHex(color.getRed())
                + colorChanelToHex(color.getGreen())
                + colorChanelToHex(color.getBlue())
                + colorChanelToHex(color.getOpacity());
    }

    private static String colorChanelToHex(double chanelValue) {
        String rtn = Integer.toHexString((int) Math.min(Math.round(chanelValue * 255), 255));
        if (rtn.length() == 1) {
            rtn = "0" + rtn;
        }
        return rtn;
    }

    @FXML
    public void initialize() {
        checkLoad();
    }

    public void setStackPaneController(StackPaneController stackPaneController) {
        this.stackPaneController = stackPaneController;
    }

    public Parametry getParametry() {
        return par;
    }


    public MenuScreenController() {
    }

}
