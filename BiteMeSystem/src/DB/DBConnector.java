package DB;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Order;

public class DBConnector {

	private static Connection conn = null;
	private static ArrayList<Order> array = new ArrayList<Order>();
	private static Order or;

	public static void main(String[] args) {
		conn = makeAndReturnConnection(); //connect
		array = DBConnector.getAllDataFromDB(conn); // get data 
		
	}

	public static Connection makeAndReturnConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Assignment2?serverTimezone=IST",
					"root", "211515838");
			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
			System.out.println("SQL connection succeed");
//			printAll(conn);
			return conn;

		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}

//	public static void printAll(Connection con) {
//
//		Statement stmt;
//		try {
//			stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM Order;");
//			while (rs.next()) {
//				// Print out the values
//				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
//						+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
//			}
//			rs.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public static ArrayList<Order> getAllDataFromDB(Connection con) {
//		ArrayList<Order> array = new ArrayList<Order>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Assignment2.Order;");
			while (rs.next()) {

				array.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
				// Print out the values
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
						+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static void saveUserToDB(Order order, Connection con) { // *******

		PreparedStatement ps;
		try {

			ps = con.prepareStatement("UPDATE Assignment2.Order SET OrderAddress=? WHERE TypeOfOrder=?;");

			ps.setString(1, order.getOrderAddress());
			ps.setString(2, order.getTypeOfOrder());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	public static void updateFlightDate(Connection con1) {
//		Statement stmt;
//		try {
//			stmt = con1.createStatement();
//			stmt.executeUpdate("UPDATE Flights SET scheduled='1930' WHERE flight='KU101'");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void updateParisFlights(Connection con1) {
//		Statement stmt;
//		try {
//			stmt = con1.createStatement();
//			stmt.executeUpdate(
//					"UPDATE Flights SET status='Expected 17:00' WHERE arriving_from='Paris' and (status='Expected 13:55' or status='On time 15:00')");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

//	public static void userPrepareStatment(Connection con) {
//		printAllFlights(con);
//		int flag = 1;
//		while (flag == 1) {
//			System.out.println("Update flights");
//			Scanner input = new Scanner(System.in);
//			System.out.println("Enter flight number:\n");
//			String numberString = input.nextLine().toString();
//			System.out.println("Enter flight arrive time:\n");
//			String arrivetime = input.nextLine().toString();
//			try {
//				PreparedStatement pstmt = con.prepareStatement("UPDATE Flights SET scheduled = ? WHERE flight = ? ");
//				pstmt.setString(1, arrivetime);
//				pstmt.setString(2, numberString);
//				pstmt.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Update finished");
//			System.out.println("do you want to update more flight's ?\nYes = 1\nNo = 0\n");
//			flag = input.nextInt();
//		}
//		System.out.println("Update finished");
//
//	}

}
