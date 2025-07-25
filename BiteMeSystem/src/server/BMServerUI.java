package server;

import java.util.Vector;

import gui.ServerFormController;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Order;

public class BMServerUI extends Application {
	final public static int DEFAULT_PORT = 5555;
	public static Vector<Order> order = new Vector<Order>();


	public static void main(String args[]) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ServerFormController aFrame = new ServerFormController(); // create StudentFrame
		aFrame.start(primaryStage);
	}

	public static void runServer(String p) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(p); // Set port to 5555

		} catch (Throwable t) {
			System.out.println("ERROR - Could not connect!");
		}

		MainServer ms = new MainServer(port);

		try {
			ms.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}

}
