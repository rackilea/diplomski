// conn is an existing java.sql.Connection to a remote server
try (Statement st = conn.createStatement()) {
    String localCsvFileSpec = "C:/Users/Jamie/Desktop/foo.csv";  // on this machine
    ((com.mysql.jdbc.Statement) st).setLocalInfileInputStream(
            new FileInputStream(localCsvFileSpec));
    st.execute(
            "LOAD DATA LOCAL INFILE '(placeholder)' " + 
            "INTO TABLE table01 " +
            "COLUMNS TERMINATED BY ',' " +
            "(id, txt) " + 
            "");
}