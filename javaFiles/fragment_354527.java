@WebMethod
        public String add_ilce (int yourInput) {

            Statement stmt=null;
            ResultSet rs=null;
            Connection conn=null;
            String deger=null;

            try {
              conn= getConnection_test();
              String query = "INSERT INTO DUAL" + "(yourAttributeName)" +"VALUES (?)";
                  PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, yourInput);
                preparedStmt.execute();



            } catch (Exception e) {
                return "hata";
            } finally {
              try {
                rs.close();
                stmt.close();
                conn.close();
              } catch (SQLException e) {
                return "hata";
              }          
            }            
            return deger;
        }