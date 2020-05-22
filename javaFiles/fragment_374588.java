ResultSet rs=ps.executeQuery();
    int rn = 0;
    while(rs.next()) {
       rn++;
       String item = rs.getString(1);
       String php  = rs.getString(2);

       System.out.println(" rn=" + rn + " item=" + item + " php=" + php);

    }
    System.out.println(" fetched total of " + rn + " rows");