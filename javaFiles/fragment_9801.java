String connectionString = 
        "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
        "DBQ=C:\\Users\\Public\\Database1.accdb;";
Connection con = DriverManager.getConnection(connectionString);
Statement st = con.createStatement();
st.execute("ALTER TABLE Customers ADD COLUMN Address TEXT(255)");