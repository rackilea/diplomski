List<String> nameList = new ArrayList<String>();
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn = DriverManager.getConnection(connectionURL, "root", "");
             Statement st=conn.createStatement();
             ResultSet rs=st.executeQuery("Select route,fromr from route"
             while(rs.next()){
                String s1=rs.getString("route");
                String s2=rs.getString("fromr");
                nameList.add(s1+" "+s2);
             }
        } catch(Exception e) {
        }

        JList list = new JList(nameList.toArray());