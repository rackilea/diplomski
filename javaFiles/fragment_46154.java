try{
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8888/atmlivedetails","root","root");  
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select atmbrno, atmbrname  from location_stat where act_brname='"+br_id+"'");
            int i=0;
            JSONArray jArray = new JSONArray();
            while(rs.next()){

        String s = rs.getString("atmbrno");
        String t = rs.getString("atmbrname");

        JSONObject arrayObj = new JSONObject();

        arrayObj.put("atmbrno",s);
        arrayObj.put("atmbrname",t);

        jArray.add(i,arrayObj);
        i++;
        }
        rs.close ();
        st.close ();
        out.print(jArray);
    }