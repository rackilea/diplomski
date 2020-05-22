Connection connMain = DriverManager.getConnection(
    "jdbc:mysql://XX.XX.X.XXX:3306/test","myusername","mypassword");
Connection[] connections = new Connection[10]; // Assuming you need ten connections
connections[0] = DriverManager.getConnection(
    "jdbc:mysql://" + CurrRemoteIPAddress + ":3306/db1","myusername1","mypassword1"); 
connections[1] = DriverManager.getConnection(
    "jdbc:mysql://" + CurrRemoteIPAddress + ":3306/db2","myusername1","mypassword1"); 
// Add as many as you need