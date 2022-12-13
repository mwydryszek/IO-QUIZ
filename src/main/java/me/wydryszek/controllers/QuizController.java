package me.wydryszek.controllers;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import me.wydryszek.quiz.JsonReader;
import me.wydryszek.quiz.Parametry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizController extends MenuScreenController {

	private StackPaneController stackPaneController;

	protected Parametry par = getParametry();

	private JsonReader json = new JsonReader();

	String[] tresc_pytania = json.getPytania().getTrescPytania();
	String[][] opcje = 	json.getPytania().getOpcje();
	String[] odpowiedzi = json.getPytania().getOdpowiedzi();


	@FXML
	private Label nrPytania;

	@FXML
	private Label trescPytania;

	@FXML
	private Button buttonA;

	@FXML
	private Button buttonB;

	@FXML
	private Button buttonC;

	@FXML
	private Button buttonD;

	@FXML
	private Label odpa;

	@FXML
	private Label odpB;

	@FXML
	private Label odpC;

	@FXML
	private Label odpD;

	@FXML
	private Label timeLeft;

	private String odp;
	private int index;
	private int random;
	protected int iloscPytan = tresc_pytania.length;
	private int czas=10;

	List<Integer> lista = new ArrayList<Integer>();

	@FXML
	void OnActionButton(ActionEvent e) {
		buttonA.setDisable(true);
		buttonB.setDisable(true);
		buttonC.setDisable(true);
		buttonD.setDisable(true);


		if(e.getSource()== buttonA) {
			odp= "A";
			if(par.getCzyLosowac()==true) {
				if(odp.equals(odpowiedzi[random]))
					par.addPunkty();
			}else {
				if(odp.equals(odpowiedzi[index]))
					par.addPunkty();
			}
		}
		if(e.getSource()== buttonB) {
			odp= "B";
			if(par.getCzyLosowac()==true) {
				if(odp.equals(odpowiedzi[random]))
					par.addPunkty();
			}else {
				if(odp.equals(odpowiedzi[index]))
					par.addPunkty();
			}
		}
		if(e.getSource()== buttonC) {
			odp= "C";
			if(par.getCzyLosowac()==true) {
				if(odp.equals(odpowiedzi[random]))
					par.addPunkty();
			}else {
				if(odp.equals(odpowiedzi[index]))
					par.addPunkty();
			}
		}
		if(e.getSource()== buttonD) {
			odp= "D";
			if(par.getCzyLosowac()==true) {
				if(odp.equals(odpowiedzi[random]))
					par.addPunkty();
			}else {
				if(odp.equals(odpowiedzi[index]))
					par.addPunkty();
			}
		}
		if(par.getCzyLosowac()==false)
			DisplayOdp();
		else
			DisplayOdpShuffle();

	}

	Timeline timer = new Timeline(
			new KeyFrame(Duration.seconds(1),
					new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							czas--;
							timeLeft.setText(String.valueOf(czas));
							if(czas<=0) {
								if(par.getCzyLosowac()==false)
									DisplayOdp();
								else
									DisplayOdpShuffle();
							}
						}
					}));

	public void nextQuestion() {

		if(index>= iloscPytan) {
			results();
		}
		else {
			nrPytania.setText("Pytanie "+(index+1)+"/"+ iloscPytan);
			trescPytania.setText(tresc_pytania[index]);
			odpa.setText(opcje[index][0]);
			odpB.setText(opcje[index][1]);
			odpC.setText(opcje[index][2]);
			odpD.setText(opcje[index][3]);
			if(par.getCzyTimer()==true) {
				timer.setCycleCount(Timeline.INDEFINITE);
				timer.play();
			}else {
				timeLeft.setVisible(false);
			}
		}
	}


	public void nextQuestionShuffle() {

		if(index>= iloscPytan) {
			results();
		}
		else {
			random=randomElement(lista);
			nrPytania.setText("Pytanie "+(index+1)+"/"+ iloscPytan);
			trescPytania.setText(tresc_pytania[random]);
			odpa.setText(opcje[random][0]);
			odpB.setText(opcje[random][1]);
			odpC.setText(opcje[random][2]);
			odpD.setText(opcje[random][3]);
			if(par.getCzyTimer()==true) {
				timer.setCycleCount(Timeline.INDEFINITE);
				timer.play();
			}else {
				timeLeft.setVisible(false);
			}
			lista.removeIf( name -> name.equals(random));
		}
	}

	public void DisplayOdp() {
		if(par.getCzyTimer()==true)
			timer.stop();

		buttonA.setDisable(true);
		buttonB.setDisable(true);
		buttonC.setDisable(true);
		buttonD.setDisable(true);

		if(!odpowiedzi[index].equals("A"))
			odpa.setStyle("-fx-text-fill: #F92C00;");
		else
			odpa.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[index].equals("B"))
			odpB.setStyle("-fx-text-fill: #F92C00;");
		else
			odpB.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[index].equals("C"))
			odpC.setStyle("-fx-text-fill: #F92C00;");
		else
			odpC.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[index].equals("D"))
			odpD.setStyle("-fx-text-fill: #F92C00;");
		else
			odpD.setStyle("-fx-text-fill: #0BA900;");

		Timeline pause = new Timeline(
				new KeyFrame(Duration.seconds(2),
						new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								odpa.setStyle("-fx-text-fill: #000000;");
								odpB.setStyle("-fx-text-fill: #000000;");
								odpC.setStyle("-fx-text-fill: #000000;");
								odpD.setStyle("-fx-text-fill: #000000;");

								odp = " ";
								czas=10;
								timeLeft.setText(String.valueOf(czas));
								index++;
								buttonA.setDisable(false);
								buttonB.setDisable(false);
								buttonC.setDisable(false);
								buttonD.setDisable(false);
								nextQuestion();
							}
						}));
		pause.setCycleCount(1);
		pause.play();
	}

	public void DisplayOdpShuffle() {
		if(par.getCzyTimer()==true)
			timer.stop();

		buttonA.setDisable(true);
		buttonB.setDisable(true);
		buttonC.setDisable(true);
		buttonD.setDisable(true);

		if(!odpowiedzi[random].equals("A"))
			odpa.setStyle("-fx-text-fill: #F92C00;");
		else
			odpa.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[random].equals("B"))
			odpB.setStyle("-fx-text-fill: #F92C00;");
		else
			odpB.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[random].equals("C"))
			odpC.setStyle("-fx-text-fill: #F92C00;");
		else
			odpC.setStyle("-fx-text-fill: #0BA900;");
		if(!odpowiedzi[random].equals("D"))
			odpD.setStyle("-fx-text-fill: #F92C00;");
		else
			odpD.setStyle("-fx-text-fill: #0BA900;");

		Timeline pause = new Timeline(
				new KeyFrame(Duration.seconds(2),
						new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								odpa.setStyle("-fx-text-fill: #000000;");
								odpB.setStyle("-fx-text-fill: #000000;");
								odpC.setStyle("-fx-text-fill: #000000;");
								odpD.setStyle("-fx-text-fill: #000000;");

								odp = " ";
								czas=10;
								timeLeft.setText(String.valueOf(czas));
								index++;
								buttonA.setDisable(false);
								buttonB.setDisable(false);
								buttonC.setDisable(false);
								buttonD.setDisable(false);
								if(par.getCzyLosowac()==false)
									nextQuestion();
								else
									nextQuestionShuffle();
							}
						}));
		pause.setCycleCount(1);
		pause.play();
	}

	public static int randomElement(List<Integer> lista) {
		Random rand = new Random();
		int randomElement = lista.get(rand.nextInt(lista.size()));
		return randomElement;
	}


	@FXML
	public void initialize() {
		for(int n=0; n<tresc_pytania.length; n++)
			lista.add(n);
		if(par.getCzyLosowac()==false)
			nextQuestion();
		else
			nextQuestionShuffle();
	}


	public void results(){
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EndScreen.fxml"));
		Pane pane = null;
		try {
			pane=loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		EndScreenController endScreenController = loader.getController();
		endScreenController.setStackPaneController(stackPaneController);
		stackPaneController.setScreen(pane);
	}


	public void setStackPaneController(StackPaneController stackPaneController) {
		this.stackPaneController= stackPaneController;
	}


}
