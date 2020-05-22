String StatusIsOK = "Status: OK";
  String StatusIsNOK = "Status: NOK";     

  if(BgColor.equals(ColorRed)){
  assertTrue(DisplayedStatus.compareTo(StatusIsNOK) == 0);
  System.out.println("OK, the color is red and the status is NOK.");
  }
  else{
      if(BgColor.equals(ColorGreen)){
          assertTrue(DisplayedStatus.compareTo(StatusIsOK) == 0);
          System.out.println("OK, the color is green and the status is OK.");
      }
      else{
          System.out.println("FAILURE:  the color "+BgColor+" and the status "+DisplayedStatus+"  don't match.");
      }           
  }