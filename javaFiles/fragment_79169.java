con = DriverManager.getConnection("jdbc:mysql:///",
            "root", "");
    st = con.createStatement();
    String sql = "CREATE DATABASE dbproject2";
    //sql = "DROP DATABASE DBNAME";
    st.executeUpdate(sql);


con = DriverManager.getConnection("jdbc:mysql:///dbproject2","root", "");

    st = con.createStatement();


    st.executeUpdate("CREATE TABLE tbl_admin(username varchar(200),password varchar(200),name varchar(200), PRIMARY KEY(username))");
    int i = st.executeUpdate("insert into tbl_admin values('admin','123456','Chris')");
    st.executeUpdate("CREATE TABLE tbl_emp(name varchar(200),department varchar(200),startTime time, PRIMARY KEY(name))");
    st.executeUpdate("CREATE TABLE tbl_records(cardNo varchar(100),holderNo varchar(100),holderName varchar(100),IODate date,IOTime time,IOGateNo varchar(100),IOGateName varchar(100),IOStatus varchar(100),departmentNo int(10), PRIMARY KEY(name))");