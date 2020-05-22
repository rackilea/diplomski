String driver = "oracle.jdbc.driver.OracleDriver"; //

  String serverName = "localhost";
  String portNumber = "1521";
  String db = "XE";
  String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
    + db; // connectOracle is the data
  // source name
  String user = "system"; // username of oracle database
  String pwd = "root"; // password of oracle database
  Connection con = null;
  ServerSocket serverSocket = null;
  Socket socket = null;
  DataInputStream dataInputStream = null;
  DataOutputStream dataOutputStream = null;

  try {
   Class.forName(driver);// for loading the jdbc driver

   System.out.println("JDBC Driver loaded");

   con = DriverManager.getConnection(url, user, pwd);// for
                // establishing
   // connection
   // with database
   Statement stmt = con.createStatement();

   serverSocket = new ServerSocket(8888);
   System.out.println("Listening :8888");

   while (true) {
    try {

     socket = serverSocket.accept();
     System.out.println("Connection Created");
     dataInputStream = new DataInputStream(
       socket.getInputStream());
     dataOutputStream = new DataOutputStream(
       socket.getOutputStream());
     System.out.println("ip: " + socket.getInetAddress());
     // System.out.println("message: " +
     // dataInputStream.readUTF());

     ResultSet res=stmt.executeQuery("select * from person");
     while(res.next()){
      System.out.println(res.getString(1));
     }

    } catch (IOException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }

    if (dataInputStream != null) {
     try {
      dataInputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }

    if (dataOutputStream != null) {
     try {
      dataOutputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   }
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }