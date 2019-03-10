import java.io.File;
import java.util.*;
import java.sql.*;
import java.lang.*;
//TO GET CONNECTORJ IN LIBRARY GO UNDER PROJECT STRUCTURE
//FILE-PROJECT STRUCTURE- LIBRARIES
public class testClassmain {
    public static void main(String args[]) {
        try{
            File in = new File("codefoo.csv");
            Scanner scan = new Scanner(in);
            //TODO figure out how store line by line into Array or straight into mySQL
            //potential ideas
                //Array of a class, Make first Line the Columns does not go into Class array
            String [] columnNames;
            String columns = scan.nextLine();
            columnNames = columns.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            //columnNames = columns.split(",");
            System.out.println(columnNames[0]);
            columnNames[8]="description_2";
            for(int i = 0; i < columnNames.length;i++) {
                System.out.print(columnNames[i] + " ");
            }
            System.out.println();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/students1", "root", "naruto100");
                if(!tableExist(con,"codefoo")){
                    //getColumns(columnNames);
                    String columnSQL = getColumnsQUERY(columnNames);
                    Statement sqlStatemnt = con.createStatement();
                    sqlStatemnt.executeUpdate(columnSQL);
                    System.out.println("table created...");
                    //ResultSet rs = sqlStatemnt.executeQuery("");

                }
                else{
                    System.out.println("table exists!");
                }
            }
            catch(Exception sqlException){
                sqlException.printStackTrace();
            }
            scan.close();
        }
        catch (Exception e){

        }

        }//end main
    public static void getColumns(String[] columns){
        System.out.println(columns.length);

    }
    public static String getColumnsQUERY(String[] columns){
        String createStatement="CREATE TABLE codefoo"+
                                    "(cfID INTEGER not NULL, ";
        for(int i = 1; i<columns.length;i++){
            createStatement += columns[i]+" VARCHAR(255), ";
        }
        createStatement+="PRIMARY KEY(cfID))";
        System.out.println(createStatement);
        return createStatement;
    }

    public static boolean tableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                    if (tName != null && tName.equals(tableName)) {
                        tExists = true;
                        break;
                }
            }
        }
        return tExists;
    }
}//end class