java.util.Properties props = new java.util.Properties();
props.setProperty("password","mypassword");
props.setProperty("user","myusername");
props.put("v$session.osuser", System.getProperty("user.name").toString());
props.put("v$session.machine", InetAddress.getLocalHost().getCanonicalHostName());
props.put("v$session.program", "My Program Name");
DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
Connection conn=
    DriverManager.getConnection("jdbc:oracle:thin:@myhostname:1521:mysid", props);