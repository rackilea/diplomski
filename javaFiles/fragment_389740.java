String string = "Fridays7/4/2017d12:50d13:50dTestd";
  String[] lineSplit1 = string.split("¬");
  for(String s: lineSplit1){
      System.out.println(s);
      String day1 = lineSplit1[0];
      String date1 = null;
      if(lineSplit1.length>1)
       date1= lineSplit1[1];
      else
          date1="thisisANullDate";
        System.out.println(day1+""+date1);
  }