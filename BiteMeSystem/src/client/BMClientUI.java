package client;

import gui.MainFormController;
import javafx.application.Application;
import javafx.stage.Stage;

public class BMClientUI extends Application {
	public static ClientController chat; // only one instance

	public static void main(String args[]) throws Exception {
		launch(args);
	} // end main

	@Override
	public void start(Stage primaryStage) throws Exception {
		chat = new ClientController("localhost", 5555);
		// TODO Auto-generated method stub

		MainFormController aFrame = new MainFormController(); // create StudentFrame
		aFrame.start(primaryStage);
	}

}
