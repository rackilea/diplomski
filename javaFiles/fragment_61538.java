public void Connect(String DataBase) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/");
                st = con.createStatement();
                st.execute("USE " + "[" + DataBase + "]");
                System.out.println("Connected to " + DataBase + " !!!");
                con.close();
            }catch(SQLException se){
                System.out.println("Cannot connect to database " + DataBase);
            }
            catch(Exception ex){
                System.out.println("Error: " + ex);
            }  
        }