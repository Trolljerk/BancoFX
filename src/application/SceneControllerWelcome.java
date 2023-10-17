package application;

import javafx.scene.*;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import banco.Account;
import banco.Bank;
import banco.CDT;

public class SceneControllerWelcome {

	private Stage stage;
	private Scene scene;

	@FXML
	private TextArea areaListarCuentas;

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

	public void listarCuentas(ActionEvent event) {
		Bank bankObj = Bank.getInstance();
		areaListarCuentas.clear();
		String cuentas = "";
		for (Account a : bankObj.getClientsAccount()) {
			cuentas += a.toString() + "\n";
		}
		areaListarCuentas.setText(cuentas);
	}
}
