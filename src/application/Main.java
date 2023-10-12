package application;

import banco.*;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

@SuppressWarnings("unused")

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
