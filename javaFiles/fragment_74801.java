String s = "ABC\n" + 
        "123\n" + 
        "ABC*HIK*UG*XY\\17\n" + 
        "1025\n" + 
        "KHJ*YU*789";
System.out.println(s.replaceAll("(?m)^ABC.*XY\\\\17\n?", ""));