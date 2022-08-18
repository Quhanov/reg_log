import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnToDB {
    public static final String user = "root";
    public static final String password = "root";
    public static final String url = "jdbc:mysql://localhost:3306/mysql";
    public static Connection conn;
    public static Statement stat;

    static{
        try{
            conn = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        try {
            stat = conn.createStatement();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
