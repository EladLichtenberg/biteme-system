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

	public static void connectToDB(Object arr) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=IST", "root",
					"@Elad15643");
			System.out.println("SQL connection succeed");
			//saveUserToDB(conn, parsingTheData(arr));
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

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