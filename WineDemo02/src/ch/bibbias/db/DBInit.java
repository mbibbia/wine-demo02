package ch.bibbias.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInit {

	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:/home/marco/git/WineInventorySnippets/src/ch/bibbias/db/" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		createNewDatabase("PT_Wine_Inventory.db");
	}
}