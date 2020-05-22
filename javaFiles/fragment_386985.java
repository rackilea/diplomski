public static void writeCookie(List<String> nameList, List<HttpCookie> cookies, int lastID) {
    Connection connection;
    Statement statement;
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:" + cookieDirectory + "cookies.sqlite");
      statement = connection.createStatement();
      connection.setAutoCommit(false);
      System.out.println.println("~~~~~~~~~~~~~~~~~Opened database successfully~~~~~~~~~~~~~~~~~~~~");
      HttpCookie myCookie;
      for (int a = 0; a < cookies.size(); a++) {
        System.out.println("=========Cookie " + a + "...===========");
        myCookie = cookies.get(a);
        System.out.println("Name = " + myCookie.getName());
        System.out.println("Value = " + myCookie.getValue());
        System.out.println("Max Age = " + myCookie.getMaxAge());
        System.out.println("Comment = " + myCookie.getComment());
        System.out.println("Path = " + myCookie.getPath());
        if (nameList.contains(myCookie.getName())) { // UPDATE COOKIE
          System.out.println("Updating");
          String sql = "UPDATE moz_cookies set value = '" + myCookie.getValue() + "' where name='" + myCookie.getName() + "';";
          statement.executeUpdate(sql);
          connection.commit();
        } else { // CREATE NEW COOKIES
          System.out.println("Creating " + myCookie.getName());
          System.out.println("id = " + lastID);
          String sql = "INSERT INTO moz_cookies (ID,BASEDOMAIN,APPID,INBROWSERELEMENT,NAME,VALUE,HOST,PATH,EXPIRY,LASTACCESSED,CREATIONTIME,ISSECURE) "
                  + "VALUES (" + lastID + ", 'site.com', 0, 0, '" + myCookie.getName() + "', '" + myCookie.getValue() + "', '.site.com', '" + myCookie.getPath()
                  + "', 1464970835, " + (System.currentTimeMillis() * 1000) + ", " + (System.currentTimeMillis() * 1000) + ", '" + myCookie.getSecure() + "' );";
          statement.executeUpdate(sql);
          connection.commit();
          lastID++;
        }
      }
      connection.commit();
      connection.close();
      statement.close();
      System.out.println("Cookies successfully saved!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }