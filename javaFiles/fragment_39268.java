String rec1 = result1.getInt("rec") 
command1 = "SELECT * from Foo WHERE (se = " + 
            rec1 + " OR rec1 = " 
            + rec1 + ")";          
        result2 = stat2.executeQuery(command1);             
        while(result2.next())
        {                   
            //this line is where the result set error pops up
            String rec2  = result2.getInt("rec")
            if(rec2 != rec1)