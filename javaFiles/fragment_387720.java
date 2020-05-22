input = new FileInputStream("path/to/properties/file");
    prop.load(input);

    Class.forName(prop.getProperty("JDBC_DRIVER"));
    System.getProperties().setProperty("javax.net.ssl.trustStore",
            "/path_to_certificate");
    String url = prop.getProperty("DB_URL")
            + "?verifyServerCertificate=false" + "&useSSL=true"
            + "&requireSSL=true"; 
    return DriverManager.getConnection(url, prop.getProperty("USER"),
            prop.getProperty("PASS"));