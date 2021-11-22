package gui;

import client.BMClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Order;
import server.MainServer;

public class EditOrderFormController {
	private Order order;
	@FXML
	private Label lblOrderAddress;
	@FXML
	private Label lblTypeOfOrder;

	@FXML
	private TextField txtOrderNumber;
	@FXML
	private TextField txtOrderAddress;
	@FXML
	private TextField txtTypeOfOrder;

	@FXML
	private Button btnSave = null;
	@FXML
	private Button btnBack = null;

	private String getOrderNumber() {
		return txtOrderNumber.getText();
	}

	private String getOrderAddress() {
		return txtOrderAddress.getText();
	}

	private String getOrderType() {
		return txtTypeOfOrder.getText();
	}

	public void loadEdit(Order ord) {
		this.order = ord;
		this.txtOrderNumber.setText(order.getOrderNumber());
		this.txtTypeOfOrder.setText(order.getTypeOfOrder());
		this.txtOrderAddress.setText(order.getOrderAddress());

	}

	@FXML
	public void getSaveBtn(ActionEvent event) throws Exception {
		String address, type;
		address = getOrderAddress();
		type = getOrderType();
		String[] arrData = new String[3];
		arrData[0] = address;
		arrData[1] = type;
		arrData[2] = getOrderNumber();
//		MainServer.setFlag();
		BMClientUI.chat.accept(arrData);
	}

	@FXML // return to main window
	public void getBackBtn(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hide order window
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane) loader.load(getClass().getResource("/gui/MainForm.fxml").openStream());
		Stage primaryStage = new Stage();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("BiteMe");
		primaryStage.show();
	}

}
