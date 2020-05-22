int count=1;//Count is being set to one
  while(RS.next()) {
      int i = 1;//i is being set to one
      count=1;//count again set to one
      while(i < count) //condition will always fail as one is never less than one
      {
          RSList.add(RS.getString(i++));//Code is never Reached

      }
      System.out.println(RS.getString("SIEBEL_NUMBER"));


      RSList.add(  RS.getString("SIEBEL_NUMBER"));


    }