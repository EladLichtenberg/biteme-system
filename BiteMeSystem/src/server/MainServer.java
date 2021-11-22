package server;
// This file contains material supporting section 3.7 of the textbook:

import java.util.ArrayList;
import logic.Order;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class MainServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
//	final public static int DEFAULT_PORT = 5555;
	ArrayList<Order> array = new ArrayList<Order>();
	public static Order[] order = new Order[6];
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public MainServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		int flag = 0;
		System.out.println("Message received: " + msg + " from " + client);
		for (int i = 0; i < 6; i++)

			if (order[i].getOrderNumber().equals(msg)) {

				System.out.println("Server Found");

				this.sendToAllClients(order[i].toString());
				flag = 1;

			}
		if (flag != 1) {
			System.out.println("Not Found");
			this.sendToAllClients("Error");

		}

//		if (msg instanceof ArrayList<?>) {
//			String[] myNewData = new String[6];
//			myNewData = ((ArrayList<String>) msg).toArray(new String[6]);
//			for (int i = 0; i < 6; i++) {
//				if (myNewData[0] == order[i].getRestaurant()) {
//					order[i].setRestaurant(myNewData[0]);
//					order[i].setOrderNumber(myNewData[1]);
//					order[i].setOrderTime(myNewData[2]);
//					order[i].setPhoneNumber(myNewData[3]);
//					order[i].setTypeOfOrder(myNewData[4]);
//					order[i].setOrderAddress(myNewData[5]);
//				}
//				this.sendToAllClients(order[i].toString());
//				
//			}
	}

//		

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
		order[0] = new Order("BBB", "1", "12:00", "0543386695", "Early", "Haifa");
		order[1] = new Order("Moses", "2", "11:00", "0543386695", "Regular", "Tira");
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {

		System.out.println("Server has stopped listening for connections.");

	}

}
//End of EchoServer class
