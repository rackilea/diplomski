// 2 places of decimal
DecimalFormat formatter = new DecimalFormat( "#.00" );

System.out.println(formatter.format(1.23));    // 1.23
System.out.println(formatter.format(1));       // 1.00
System.out.println(formatter.format(1.234));   // 1.23