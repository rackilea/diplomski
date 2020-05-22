String first="01.25";
String second="00.35";
Float f1=Float.parseFloat(first);
Float f2=Float.parseFloat(second);
Float f3=f1+f2;
String result=new DecimalFormat("00.00").format(f3);
System.out.println("value"+result);