package br.edu.iff.projetoJJR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

		private static ConexaoUtil conexaoUtil;
		
		public static ConexaoUtil getInstance() {
			if(conexaoUtil== null) {
				conexaoUtil = new ConexaoUtil();				
			}
			return conexaoUtil;
			
			
			
		}
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jjr?useTimezone=true&serverTimezone=UTC","root","2526");
		
		
		}
		public static void main(String []args) throws ClassNotFoundException, SQLException {
			try {
			System.out.println(getInstance().getConnection());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
}
