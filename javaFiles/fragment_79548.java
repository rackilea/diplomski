Connection conn = CreatingDerbyDJB.dbConnection();

            try{
                String query = "INSERT INTO  Items (Name,Color,ItemName,SchoolName, Description) VALUES(?,?,?,?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);


                pstmt.execute();
                conn.close();
              }catch(Exception e)
            {
                  e.printStackTrace();
            }       }