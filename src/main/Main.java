package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FileLoader;
import view.MainView;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FileLoader.ucitajFajlove();
		primaryStage.setScene(new Scene(new MainView(),900, 600));
		primaryStage.show();
	}

}
