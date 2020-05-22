Right click on project -> Build Path -> Configure build path -> Add external jar

try {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@<hostname>:<port num>:<DB name>"
                ,"user","password");
     Statement stmt = con.createStatement();
     System.out.println("Created DB Connection....");
    } catch (ClassNotFoundException e) {
          e.printStackTrace();
    } catch (SQLException e) {
       e.printStackTrace();
    }