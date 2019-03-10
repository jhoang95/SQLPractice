
import java.sql.*;

public class DatabaseConnection {
    //fields
    public static Statement stmtObj;
    public static Connection connectDB;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;
//establishing Database Connection
    public static Connection getConnection(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
    String  url = "jdbc:mysql://localhost:3306/students1",
            user = "root",
            pass = "naruto100";

    connectDB = DriverManager.getConnection(url,user,pass);
}
        catch(Exception sqlException){
                sqlException.printStackTrace();
                }
                return connectDB;
                }
//Method to retrieve Records from Database








                }//end class
