package me.wydryszek.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EndScreenController extends QuizController{

	private StackPaneController stackPaneController;
	
    @FXML
    private Label wynik;

    @FXML
    private Label procenty;
    
    private int proc;

    @FXML
    void powrotMenu() {
    	par.setPunkty(0);
    	stackPaneController.loadMenuScreen();
    }
    
    
    @FXML
    public void initialize() {
    	wynik.setText("Twój wynik to: "+par.getPunkty()+"/"+ iloscPytan);
    	proc = (int)((par.getPunkty()/(double) iloscPytan)*100);
    	procenty.setText(proc+"%");
    }
    
	public void setStackPaneController(StackPaneController stackPaneController) {
		this.stackPaneController= stackPaneController;
	}

}
