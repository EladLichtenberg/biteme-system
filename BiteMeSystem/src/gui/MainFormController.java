package gui;

import java.io.IOException;

import client.BMClientUI;
import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Order;

public class MainFormController {

	private OrderFormController OFC;

	@FXML
	private Button btnShowOrder = null;

	@FXML
	private Button btnEditOrder = null;
	@FXML
	private Button btnExit = null;

	@FXML
	private Label lblNumber;

	@FXML
	private TextField txtOrderNumber;

	private String getsOrderNumber() {
		return txtOrderNumber.getText();
	}

	public void getShowOrderBtn(ActionEvent event) throws Exception {
		String OrderNumber;
		FXMLLoader loader = new FXMLLoader();
		OrderNumber = getsOrderNumber();

		if (OrderNumber.trim().isEmpty()) {

			System.out.println("You must enter order number");
		} else {

			BMClientUI.chat.accept(OrderNumber);

			if (ChatClient.o1.getOrderNumber().equals("Error")) {
				System.out.println("Order number Not Found");

			} else {
				System.out.println("order number Found");
				((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
				Stage primaryStage = new Stage();
				Pane root = loader.load(getClass().getResource("/gui/OrderForm.fxml").openStream());
				OrderFormController orderFormController = loader.getController();
				orderFormController.loadOrder(ChatClient.o1);

				Scene scene = new Scene(root);
				primaryStage.setTitle("order view");

				primaryStage.setScene(scene);
				primaryStage.show();
			}
		}
	}

	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/MainForm.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("Show Order");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

//	public void getEditOrderBtn(ActionEvent event) throws Exception {
//		((Node) event.getSource()).getScene().getWindow().hide(); // hide main window
//		FXMLLoader loader2 = new FXMLLoader();
//		AnchorPane root = (AnchorPane) loader2.load(getClass().getResource("/client/EditOrderForm.fxml").openStream());
//		Stage primaryStage = new Stage();
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.setResizable(false);
//		primaryStage.setTitle("BM-Edit Order");
//		primaryStage.show();
//
//	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("Come back soon:)");
		System.exit(0);
	}

	public void loadOrder(Order o1) {
		this.OFC.loadOrder(o1);
	}

	public void display(String message) {
		System.out.println("message");
	}

}
