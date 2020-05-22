try {
        String SQL = "select * from dbo.Student";

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String url = String.format("jdbc:jtds:sqlserver://***.database.windows.net:1433/<your database name>;user=***;password=***;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        conn = DriverManager.getConnection(url);

        stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }