public class DB {

public static void main (String[]args) {
        getConnection();
    }

    public static Connection getConnection(){
        String uRl = "jdbc:mysql://localhost:3306/weather";
        String user = "root";
        String password = "0888150";
        Connection mycon = null;
        try {
            String driver ="com.mysql.jdbc.Driver";
            Class.forName(driver);

            mycon = DriverManager.getConnection(uRl,user,password);
            Statement st = mycon.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM db");
            while(rs.next()){
                System.out.println(rs.getString("City")+", "+rs.getString("date")+ ", "+rs.getString("Low")+ ", "+
            rs.getString("High")+", " +rs.getString("status"));
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mycon;

    }
    }