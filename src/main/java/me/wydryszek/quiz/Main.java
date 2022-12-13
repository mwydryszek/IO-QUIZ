package me.wydryszek.quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import me.wydryszek.controllers.StackPaneController;


public class Main extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/StackPaneWindow.fxml"));
		StackPane stackpane = loader.load();
		
		StackPaneController controller = loader.getController();
		loader.setController(controller);
		Scene scene = new Scene(stackpane, 600, 500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quiz");	
		primaryStage.show();
		
	}
	

}
