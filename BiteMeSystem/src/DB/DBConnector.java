package DB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Order;
import server.MainServer;

public class DBConnector {
	private static Order[] order = new Order[6];

	public static Connection connectToDB() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/bitemesystem?serverTimezone=IST", "root",
					"@Elad15643");
			System.out.println("SQL connection succeed");

		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;

	}

	public static Order[] shareData(Connection conn) {
		Statement stmt;
		int i = 0;
		try { // saving orders data
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM bitemesystem.order\r\n;");
			while (rs.next()) {
				order[i] = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

//	public static String[] parsingTheData(Object arr) {
//		@SuppressWarnings("unchecked") // using ArrayList<String> only so we don't need to check safety
//		ArrayList<String> ar = (ArrayList<String>) arr;
//		return ar.toArray(new String[ar.size()]);
//	}

	public static void updateData(Connection con, String[] arrUser) {
		PreparedStatement ps;
		try {
			//
			ps = con.prepareStatement("UPDATE bitemesystem.order\r\n" + "SET TypeOfOrder = ?, OrderAddress= ? \r\n"
					+ "WHERE OrderNumber = ?;");

			ps.setString(1, arrUser[1]);
			ps.setString(2, arrUser[0]);
			ps.setString(3, arrUser[2]);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}

}