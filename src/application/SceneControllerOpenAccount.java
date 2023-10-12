package application;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import banco.Bank;

public class SceneControllerOpenAccount {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField numCuenta;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> comboBox;

	private Stage stage;
	private Scene scene;

	public void switchWelcome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void crearCuenta(ActionEvent event) {
		try {
			Bank bank = Bank.getInstance();
			int numCuenta = Integer.parseInt(this.numCuenta.getText());
			String tipoCuenta = comboBox.getValue();
			char tipoCuentaLetra;

			switch (tipoCuenta) {
			case "Ahorros":
				tipoCuentaLetra = 'A';
				break;
			case "Corriente":
				tipoCuentaLetra = 'C';
				break;
			case "CDT":
				tipoCuentaLetra = 'D';
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipoCuenta);
			}
			if (bank.openAccount(tipoCuentaLetra, numCuenta)) {
				System.out.println("Cuenta creada: " + tipoCuenta + ", " + numCuenta);
			}
		} catch (Exception e) {
			System.err.println("Type numbers only in numeroCuenta/Choose an option in tipoCuenta");
		}
	}

	@FXML
	void initialize() {
		comboBox.getItems().removeAll(comboBox.getItems());
		comboBox.getItems().addAll("Ahorros", "Corriente", "CDT");
	}
}
