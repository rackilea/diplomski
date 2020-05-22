DecimalFormat format1 = 
    (DecimalFormat)NumberFormat.getNumberInstance(Locale.US);
format1.applyPattern("##,#0¤");

DecimalFormat format2 = 
    (DecimalFormat)NumberFormat.getNumberInstance(Locale.US);
format2.applyPattern("¤##,#0");

System.out.println(format1.parse("1,23$"));
System.out.println(format2.parse("$1,23"));