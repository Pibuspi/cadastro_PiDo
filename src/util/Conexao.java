package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

 
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/database_feliz"; 
    private static final String USER = "root"; 
    private static final String PASS = ""; 

   
    public static Connection getConexao() {
        try {
        	
            
            Class.forName("com.mysql.jdbc.Driver"); 
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do MySQL não encontrado! Verifique se o .jar está no Build Path.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}