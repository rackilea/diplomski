public void updateTableData() {
            PreparedStatement pstmt = null;
            try { 
                //create calendar date -1 day
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -1); 

                // preparing query to update record In db. 
                pstmt = connection.prepareStatement("update a set a.dCreateTime= ? from tbet a, tuser b where a.iUserKey= b.iUserKey and b.sUserid = ? and a.dCreateTime> GETDATE()-5");
                // Set name value which you wants to update. 
                pstmt.setDate(1, new java.sql.Date(cal.getTime().getTime()));
                // Set id of record which you wants to update.
                pstmt.setString(2, "atest211");
                // To execute update query.
                pstmt.executeUpdate();

                // Printing all records of user table after updating record.
                String query = "select * from tbet where iUserKey=53298 ORDER BY tbet.dCreateTime desc";
                statement = connection.createStatement();
                // Get the contents of user table from DB
                ResultSet res = statement.executeQuery(query);
                // Print the result untill all the records are printed
                // res.next() returns true if there is any next record else returns
                // false
                while (res.next()) {
                    System.out.println(String.format("%s - %s - %s - %s ", res.getString(1), res.getString(2),
                            res.getString(3), res.getString(4)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }