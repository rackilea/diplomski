String[] parts = line.split("|");
String part1 = parts[0];
String part3 = parts[1];         
Connection con = DriverManager.getConnection(Main.host, Main.uName, Main.uPass);

Statement rstmt = con.createStatement();
String r = "SELECT * FROM `xf_user` WHERE `user_id` = " + part1 + ";";
ResultSet rs = rstmt.executeQuery(r);

StringBuilder sb = new StringBuilder();
while (rs.next()) {
     String uuid = UUID.randomUUID().toString();
     String username = rs.getString("username");
     String print = username + " " + part3 + " " + uuid;
     if(Integer.parseInt(part3) >= 0)
         sb.append(print + "\n");
}
System.out.println(sb.toString());