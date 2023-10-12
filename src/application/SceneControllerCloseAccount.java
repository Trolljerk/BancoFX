package application;

import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import banco.Bank;

public class SceneControllerCloseAccount {

	private Stage stage;
	private Scene scene;
	@FXML
	private TextField numCuenta;

	public void switchWelcome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void cerrarCuenta(ActionEvent event) {
		try {
			int numCuentaInt = Integer.parseInt(this.numCuenta.getText());
			Bank bank = Bank.getInstance();
			if (bank.closeAccount(numCuentaInt)) {
				System.out.println("Cuenta: " + numCuentaInt + " cerrada.");
			}
		} catch (Exception e) {
			System.err.println("Input error in numero cuenta");
		}
	}
}
