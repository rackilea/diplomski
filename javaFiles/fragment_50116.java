try {
    String sql ="select * from GameList1 where Name LIKE ?";
    String PERCENTAGE_SIGN="%";
    pst=conn.prepareStatement(sql);
    pst.setString(1, PERCENTAGE_SIGN+txt_Search.getText()+PERCENTAGE_SIGN);

    rs=pst.executeQuery();
    if(rs.next()) {

        String add1=rs.getString("GameID");
        txt_GameID.setText(add1);
        String add2=rs.getString("Name");
        txt_Name.setText(add2);
        String add3=rs.getString("Company");
        txt_Company.setText(add3);
        String add4=rs.getString("Format");
        txt_Format.setText(add4);
        String add5=rs.getString("YearMade");
        txt_Year.setText(add5);
        String add6=rs.getString("YearReleased");
        txt_Release.setText(add6);


                     }
    }