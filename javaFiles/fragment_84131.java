/*
     * We're goin to insert several arrays into the HANA table, 
     * with different lengths
     * 
     * let's assume we already got a table like this
     * CREATE COLUMN TABLE T3 ( ID INT PRIMARY KEY, C1 INT ARRAY );
     */

    Integer[][] myarr ={ {1}, {1,2}, {1,2,3,4,5}, {1,2}, {1,2,3} };

    String testSection = "Insert Arrays one by one";
    stopWatch.start(testSection);
    myDBconn.setAutoCommit(false);

    Statement stmt = myDBconn.createStatement();

    stmt = myDBconn.createStatement();

    stmt.execute("TRUNCATE TABLE DEVDUDE.T3");

    // loop over our array of arrays and visit each once
    for (int i = 0 ; i < (myarr.length); i++) {
        int curr_length = myarr[i].length;

        String arrayFunction = "ARRAY (";

        for (int j = 0; j < (curr_length); j++){

            arrayFunction = arrayFunction.concat(myarr[i][j].toString()) ;

            // add comma if this is not the last element
            if (j < (curr_length - 1)){
                arrayFunction = arrayFunction.concat(", ") ;
            }
        }

        arrayFunction = arrayFunction + ")" ;
        // now the arrayFunction should loook like this
        // ARRAY ( ..., .... ,... )

        String insCMD = "INSERT INTO T3 (id, c1) "
                        + " VALUES (" + i + ", " 
                        + arrayFunction 
                        + " ) ";

        System.out.println(insCMD);
        int affectedRows = stmt.executeUpdate(insCMD);

        System.out.println("Loop round " + i
                    + ", last affected row count " + affectedRows);
        }


    myDBconn.commit();
    stmt.close();
    stmt = null;