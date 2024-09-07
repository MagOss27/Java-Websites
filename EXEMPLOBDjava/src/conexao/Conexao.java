package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/exemplobd"; // Verifique se o nome do banco de dados está correto
    private static final String user = "Fernanda_Poema";
    private static final String password = "12345";
    
    private static Connection conn;

    public static Connection getConexao() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password); // Corrigido 'DriveManager' para
                                                                         // 'DriverManager'
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
