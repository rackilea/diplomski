driver ="net.sourceforge.jtds.jdbc.Driver;
url ="jdbc:jtds:sqlserver://Ip:port;databasename=xxx";
user = "xxx";
pass = "xxx";
Class.forName(driver);
connection = DriverManager.getConnection(url, user, pass);