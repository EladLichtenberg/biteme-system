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
	private static Order[] order = new Order[6];

	public static Order[] connectToDB(Object arr) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bitemesystem?serverTimezone=IST",
					"root", "@Elad15643");
			System.out.println("SQL connection succeed");
			order = shareData(conn);
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return order;

	}

	private static Order[] shareData(Connection conn) {
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

	public static String[] parsingTheData(Object arr) {
		@SuppressWarnings("unchecked") // using ArrayList<String> only so we don't need to check safety
		ArrayList<String> ar = (ArrayList<String>) arr;
		return ar.toArray(new String[ar.size()]);
	}

	public static void saveUserToDB(Connection con, String[] arrUser) {
		PreparedStatement ps;
		try {
			//
			ps = con.prepareStatement(
					"INSERT INTO userdetail (UserName, ID, Department, Tel)\r\n" + "VALUES (?,?, ?,?);");
			ps.setString(1, arrUser[0]);
			ps.setString(2, arrUser[1]);
			ps.setString(3, arrUser[2]);
			ps.setString(4, arrUser[3]);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}

}