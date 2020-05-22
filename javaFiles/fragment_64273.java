try {
    String url = "jdbc:odbc:" + "userstuff"; 

    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

    Connection con = DriverManager.getConnection(url,"","");

    // Gets a statement
    Statement state1 = con.createStatement();
    Statement state2 = con.createStatement();

    String query1 = "SELECT description FROM topics WHERE title = '" + title + "'";

    // selects the description for the selected topic ( title will be referenced to the chosen topic)
    ResultSet results1 = state1.executeQuery( query1 );

    while( results.next() ){

        System.out.println( results1.getString( "description" );
    }

    // selects * of the rows from "comment" table where the topic equals the selected title.
    String query2 = "SELECT * FROM comment WHERE topic = '" + title + "'";

    ResultSet results2 = state2.executeQuery( query2 );

    while( results2.next() ){

        System.out.println( results2.getString( 1 ); // here 1 is tables 1st column
        System.out.println( results2.getString( 2 ); // here 2 is tables 2nd column
    }
} Exception( SQL e){

    e.printStackTrace();
}