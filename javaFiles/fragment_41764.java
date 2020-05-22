try { 
             Class.forName("com.mysql.jdbc.Driver");

             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recall", "username", "password");

             Statement statement = connection.createStatement();
             String query = "SELECT * FROM names";
             ResultSet rs = statement.executeQuery(query);

             while (rs.next())
             {      
                String name = rs.getString("name");         
                names.addItem(rs.getString("name"));
             }//end while
             connection.close();
             } catch (Exception e) {
                  e.printStackTrace();
             }