package derbyconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author john.stone571
 */
public class DerbyConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
           
            String host = "jdbc:derby://localhost:1527/TeamMembers";
            String uName = "student";
            String uPass = "student";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement( );
            String sql = "select * from STUDENT.MEMBERS";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next( ) ) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("FIRSTNAME");
                String last_name = rs.getString("LASTNAME");
                String job = rs.getString("JOBTITLE");
                System.out.println( id_col + " " + first_name + " " + last_name + " " + job );
            }
        
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        }
        
    }
    
}
