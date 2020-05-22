ResultSet result=null ;
        PreparedStatement pstmt = null;
        ArrayList yourlist = new ArrayList();
        try
        {
            String queryString = "select yourfield from ....";
             result = pstmt.executeQuery();

            while(result.next())
            {
                yourlist.add(result.getInt("yourfield")); //if you are returning varchar so use getString

            }

        }    
        catch (SQLException e){
            System.out.println("Exception: " + e.toString() );
                    }

        finally
        {
            if(result!=null)
                result.close();
            if(pstmt!=null)
                pstmt.close();
        }