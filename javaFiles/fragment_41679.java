public static void main (String[] args)
{
    try
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://nameMyLaptop//SQLEXPRESS";
        Connection con = DriverManager.getConnection(connectionUrl);
    }

//Insert catches
}