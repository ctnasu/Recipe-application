import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFunctions {

    public Connection connect_to_db(String TarifDB, String user, String pass) {
        Connection conn = null;
        try {
            // PostgreSQL JDBC sürücüsünü yükle
            Class.forName("org.postgresql.Driver");

            // Bağlantıyı kur
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + TarifDB, user, pass);

            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver bulunamadı: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }
}