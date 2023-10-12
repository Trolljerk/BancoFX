package application;

import javafx.scene.*;

import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class SceneControllerWelcome {

	private Stage stage;
	private Scene scene;

	public void switchCloseAccount(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CloseAccount.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchOpenAccount(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("OpenAccount.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
