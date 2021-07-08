import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String getProductsCountWithNameContaining() {
        String SQL = "SELECT count(*) FROM products where name like('%о%')";
        String name = "";
        try (Connection conn = connect();) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            name = rs.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return name;
    }

    public String showSport(){
        String SQL = "SELECT * FROM sport";
        String result = "";
        try (Connection conn = connect();) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            for(int i = 1; i <= numberOfColumns; i++)
            {
                result += rsMetaData.getColumnLabel(i) + "\t";
            }
            result += "\n";
            while (rs.next())
            {
                for(int e = 1; e <= rsMetaData.getColumnCount(); e++)
                {
                    result += rs.getString(e) + "\t " ;
                }
                result += "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return  result;
    }

    public String showCoach(){
        String SQL = "SELECT * FROM coach";
        String result = "";
        try (Connection conn = connect();) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            for(int i = 1; i <= numberOfColumns; i++)
            {
                result += rsMetaData.getColumnLabel(i) + "\t" + "\t";
            }
            result += "\n";
            while (rs.next())
            {
                for(int e = 1; e <= rsMetaData.getColumnCount(); e++)
                {
                    result += rs.getString(e) + "\t" + "\t";
                }
                result += "\n";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
