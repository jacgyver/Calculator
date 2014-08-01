package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private Scene scene;
	private BorderPane root;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
			this.primaryStage = primaryStage;
			this.primaryStage.getIcons().add(new Image("file:resources/calculator.jpg"));
			this.primaryStage.setTitle("Calculator for JAVA");
			
			initLayout();
			calculatorLayout();
			
	}
	private void initLayout() {
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
			scene = new Scene(root,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void calculatorLayout() {
		try {
			AnchorPane calculator = (AnchorPane)FXMLLoader.load(getClass().getResource("view/CalculatorLayout.fxml"));
			root.setCenter(calculator);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Scene getScene() {
		return scene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
