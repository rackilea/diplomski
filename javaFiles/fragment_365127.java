try {
        dbAccessSetUp();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*)FROM taddress A INNER JOIN tlink L ON A.address_id = L.internal_address_id WHERE L.ext_client_id =" + this.clientNo);
        int count=0;
        while(rs.next()) {
            count =  ((Number) rs.getObject(1)).intValue();

        }

        if(count > 0) {
            assertTrue(true);
            System.out.println(count + " record(s) in taddress based on ExtClientNo");
        }
        else {
            fail("No records in taddress");
        }

    }catch(Exception ex) {
        System.out.println(ex.getMessage());
    }