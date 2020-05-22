try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con  = DriverManager.getConnection(url, user, password);

        System.out.println("Database connection succesful to: " + url);

        }catch(Exception e){
            System.out.println("Error in connecting");
        }