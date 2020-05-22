public static void editPassword(String user, String siteEdited, String site, String usernamej, String password, String info){
     try{
         System.out.println(usernamej);
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:res/Users");
         stmt = c.prepareStatement("UPDATE " + user + " SET Username = ? Where SiteName = ?");
         stmt.setString(1, usernamej);
         stmt.setString(2, siteEdited);
         stmt.executeUpdate();
         stmt.close();
         c.close();
     }catch(Exception e){
         System.err.print( e.getClass().getName() + ": " + e.getMessage());
     }
 }