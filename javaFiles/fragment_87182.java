int count = 1;
   while(RS.next()) {
      RSList.add(RS.getString(count++));
      System.out.println(RS.getString("SIEBEL_NUMBER"));
      RSList.add(  RS.getString("SIEBEL_NUMBER"));
    }