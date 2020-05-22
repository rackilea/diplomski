public static void main(String[] args) {
    String connurl = "jdbc:mysql://10.247.36.174:3306/d_accesslog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "****";
    String pwd = "****";
    // Use a prepared parameter in the sql string
    String sql = "INSERT INTO t_weblogic_test (RawData) values (?)";

    String[] levParam = { "DEBUG", "WARN", "INFO", "ERROR" };
    List<String> listparam = Arrays.asList(levParam);

    // Use a try-with-resources block to automatically handle the closing of the resources
    try(Connection con = DriverManager.getConnection(connurl, username, pwd); 
        PreparedStatement ps = con.prepareStatement(sql);
        BufferedReader br = new BufferedReader(new FileReader("All.log"));) {

      String line = null;
      while ((line = br.readLine()) != null) {
        // Get first token
        String firstWord = line.split(" ",2)[0];
        if(listparam.contains(firstWord)) { // Start of the first log message
          // Process all the messages from the log file
          processMessages(line, br, listparam, ps);
          break;
        }
      }
    } catch(SQLException ex) {
      // ex handling
    } catch(IOException ex) {
      // ex handling
    }
  }

  private static void processMessages(String line, BufferedReader br, List<String> listparam, PreparedStatement ps) throws IOException, SQLException {
    String message = line;

    // Scan until the end of the message, eg the start of the next message
    while ((line = br.readLine()) != null) {
      // Get first token
      String firstWord = line.split(" ",2)[0];
      if(listparam.contains(firstWord)) { // Start of the next log message
        // Insert your message
        ps.setString(1, message);
        ps.executeUpdate();
        message = line; // Start of the new message
      } else { // Continuation of the current message
        message = message.concat(line);
      }
    }

    if(!message.isEmpty()) {
      // Insert the last message from the log file
      ps.setString(1, message);
      ps.executeUpdate();
    }
  }