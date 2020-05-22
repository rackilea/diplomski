if(myDataSource instanceof javax.sql.XADataSource)
        System.out.println("XA datasource");
    else{
        try{
            myDataSource.unwrap(javax.sql.XADataSource.class);
            System.out.println("XA datasource");
        } catch(SQLException sqle){
            System.out.println("Not an XA datasource");
        }
    }