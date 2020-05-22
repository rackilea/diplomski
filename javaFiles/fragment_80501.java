public List<Date> getTime(){
      List<Date> dates = new ArrayList<Date>();
      DateFormat format;

      try {

          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, "root", "");

          Statement stmt = con.createStatement();

          ResultSet result = stmt.executeQuery("SELECT * FROM error_log WHERE service_source = 'Billbox' ");

          while (result.next()) {  //retrieve data
              String ds = result.getString("error_date");
              format = new SimpleDateFormat("M/d/yyyy H:m:s a");

              dates.add((Date)format.parse(ds));  

          }
          con.close();

      } catch (Exception ex) {
          Logger.getLogger(LogDB.class.getName()).log( 
                        Level.SEVERE, null, ex);
      }
      return dates;
  }