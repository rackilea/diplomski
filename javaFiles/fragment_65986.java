try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","PROJECT","PROJECT");
            str="insert into CUSTOMERMASTER values(?,?,?,?,?)";
            ps=con.prepareStatement(str);

            ps.setString(1,name);
            ps.setInt(2,code);
            ps.setString(3,address);
            ps.setInt(4,telephone);
            ps.setString(5,email);
            ps.executeUpdate();

            con.commit();     
            ps.close();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }