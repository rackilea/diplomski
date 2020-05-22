BigDecimal bd2=BigDecimal.valueOf(11.12345678955);
BigDecimal bd3=new BigDecimal("1");
BigDecimal bdDiv = bd2.divide(bd3,38,RoundingMode.HALF_UP);
System.out.println(bdDiv);
BigDecimal bdDivDOWN = bd2.divide(bd3,10, RoundingMode.HALF_DOWN);
System.out.println(bdDivDOWN);               
BigDecimal bdDivUP = bd2.divide(bd3,10, RoundingMode.HALF_UP);
System.out.println(bdDivUP);