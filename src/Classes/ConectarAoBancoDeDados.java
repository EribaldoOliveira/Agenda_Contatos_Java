package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectarAoBancoDeDados {
	
	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdagenda", "root", "");
		
			
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "O Driver do Banco de dados não foi encontrado! " + e);
		}

		return null;
		 
	}
	


}
