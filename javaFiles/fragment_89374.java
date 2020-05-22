public void addCSVtoDB() {
    try ( Transaction ignored = graphDb.beginTx();
            Result result = graphDb.execute( "LOAD CSV WITH HEADERS FROM \"file:////Users/My_User/csv_file.csv\" AS csvLine\n" )
        {

    }