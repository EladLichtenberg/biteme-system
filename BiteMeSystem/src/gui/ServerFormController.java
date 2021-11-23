package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Order;
import server.BMServerUI;

public class ServerFormController {

	@FXML
	private TextField txtIP;

	@FXML
	private TextField PortTextField;

	@FXML
	private TextField txtStatus;

	@FXML
	private Button ConnectBtn;

	@FXML
	private Button ExitBtn;

	private String getport() {
		return PortTextField.getText();
	}

	public void loadServer() {
		this.txtStatus.setText("Active");

	}

	public void Done(ActionEvent event) throws Exception {
		String port;
		port = getport();
		if (port.trim().isEmpty()) {
			System.out.println("You must enter a port number");
		} else {
			// ((Node) event.getSource()).getScene().getWindow().hide(); // hide main window
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			BMServerUI.runServer(port);
			loadServer();

		}
	}

	public void start(Stage primaryStage) throws Exception { // get the gui windows the is relevant
		Parent root = FXMLLoader.load(getClass().getResource("/gui/ServerForm.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("Exit Server Window");
		System.exit(0);
	}

	public void getDisconnectBtn(ActionEvent event) throws Exception {
		System.out.println("Disconnect Server");
	}

}
