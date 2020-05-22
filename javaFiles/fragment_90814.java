//Execute when button is pressed
            System.out.println("You clicked the button SAVE");
            String url = "jdbc:mysql://127.0.0.1:3306/mydb";
            String login = "root";
            String passwd = "toor";
            Connection cn = null;
            Statement st = null;
            ResultSet rs = null;
            System.out.println("Connecting to database..");
            try {

                cn = DriverManager.getConnection(url, login, passwd);
                System.out.println("Database Connected");
               st = cn.createStatement();
               String sql = "SELECT * FROM impacts";
               rs = st.executeQuery(sql);
               while (rs.next()){
                   //do something
               }


               //instruction.executeQuery(req);
           } // Try
           catch (SQLException ex)
           {
               System.out.println("Connexion à la base de données impossible");
               ex.printStackTrace();
           }
            finally {
               try{
                   if (cn != null ){
                       cn.close();
                       }               
                       if (st != null ){
                           st.close();
                           }  
                       if (rs != null ){
                           rs.close();
                           }  
               } catch (SQLException sqle){
                   sqle.printStackTrace();
               }
           }