package server;
// This file contains material supporting section 3.7 of the textbook:

import java.net.InetAddress;
import java.util.ArrayList;

import client.BMClientUI;
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
	public static String ipAdrr;
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public MainServer(int port) {
		super(port);
	}

//	public static void setFlag() {
//		editFlag = 1;
//	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */

	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {

		ipAdrr = client.toString();

		if (msg instanceof String[]) {

			DB.DBConnector.updateData(DB.DBConnector.connectToDB(), (String[]) msg);
			System.out.println("Updated");
			this.sendToAllClients("Updated");
			return;
		}
		int m = 0;
		int flag = 0;
		System.out.println("Message received: " + msg + " from " + client);
		m = Integer.parseInt((String) msg);
		if (order[m - 1] != null) {
			for (int i = 0; i < 6; i++) {
				if (order[i].getOrderNumber().equals(msg)) {
					System.out.println("Server Found");
					this.sendToAllClients(order[i].toString());
					flag = 1;
				}
			}
		}
		if (flag != 1) {
			System.out.println("Not Found");
			this.sendToAllClients("Error");
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
		order = DB.DBConnector.shareData(DB.DBConnector.connectToDB());
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
