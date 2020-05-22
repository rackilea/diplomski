int k=1;
        int oldId=1;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String  urlCn="jdbc:derby://localhost:1527/myDb";
            Connection   cn = DriverManager.getConnection(urlCn, "omer", "1234");
            Statement stmt = cn.createStatement();
            String sql = "SELECT * FROM QUESTIONS";
            ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement st;
            while (rs.next()) {
                st = cn.prepareStatement("update QUESTIONS set id = ? where id = ?");
                oldId=rs.getInt("id");
                if(oldId!=k){
                    st.setInt(1,k);
                    st.setInt(2,oldId);
                    st.executeUpdate(); 
                }
                k++;
            }
            rs.close();
            cn.close();
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(addQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }           
        catch (SQLException ex) {
            Logger.getLogger(addQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }