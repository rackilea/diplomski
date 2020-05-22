try{
    Class.forName("com.mysql.jdbc.Driver"); // to set the driver
    Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "<Database username>", "<Database password>"); // connect to database
    Statement st = connect.createStatement(); 
    Resultset rs = st.executeQuery( "SELECT * FROM <tablename>" );

    while( rs.next() ){
            System.out.print( rs.getString(1) );
    }
}
catch( Exception e ){
    System.out.print( e );
}