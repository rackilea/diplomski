import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewClass1 {
    public static void main(String[] args) {
        try {

            String fileName = "yourfile.csv";
            List<String[]> customerList = readWholeCsvFile(fileName);
            Connection conn = getConnection();
            persistWithOutDataClass(conn,customerList);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<String[]> readWholeCsvFile(String fileName) throws IOException{
        List<String[]> myEntries = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(fileName), ',' ,'\'', 1);
        myEntries = reader.readAll();
        return myEntries;        
    }

    public static List<Customer> readCsvFileLineByLine(String fileName) throws IOException{
        List<Customer> customerList = new ArrayList<>();
        String [] nextLine;
        CSVReader reader = new CSVReader(new FileReader(fileName), ',' ,'\'', 1);
        while ((nextLine = reader.readNext()) != null) {        
            customerList.add(new Customer(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4]));
        }       
        return customerList;        
    }

    private static Connection getConnection() {
        Connection conn = null; //sets values to null before actually attempting a connection               
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionStringURL = "jdbc:mysql://us-cdbr-azure-west-b.cleardb.com:3306/acsm_0a00c1270f36f77"; //database name
            conn = DriverManager.getConnection(connectionStringURL, "username", "password"); //username, password
            if (conn == null) //check to make sure that it actually connected
                System.out.println("Connection Failed");
            else
                System.out.println("Success");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    private static void persistWithOutDataClass(Connection conn, List<String[]> customerList) throws SQLException{
        String insertStatement = " insert into Customer (First Name, Last Name, Job, Email, Phone Number) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(insertStatement);
        for(String[] row : customerList){
            preparedStmt.setString (1, row[0]);
            preparedStmt.setString (2, row[1]);
            preparedStmt.setString (3, row[2]);
            preparedStmt.setString (4, row[3]);
            preparedStmt.setString (5, row[11]);
            preparedStmt.addBatch();
        }
        preparedStmt.executeBatch();
    }

    private static void persistWithDataClass(Connection conn, List<Customer> customerList) throws SQLException{
        String insertStatement = " insert into Customer (First Name, Last Name, Job, Email, Phone Number) values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(insertStatement);
        for(Customer cust : customerList){
            preparedStmt.setString (1, cust.getFirstName());
            preparedStmt.setString (2, cust.getLastName());
            preparedStmt.setString (3, cust.getJob());
            preparedStmt.setString (4, cust.getEmail());
            preparedStmt.setString (5, cust.getPhone());
            preparedStmt.addBatch();
        }
        preparedStmt.executeBatch();
    }
}