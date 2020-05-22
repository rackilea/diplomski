//import java.util.Date;
//import java.text.SimpleDateFormat;

String s = "190415";
SimpleDateFormat sdfIn = new SimpleDateFormat("yyMMdd");
SimpleDateFormat sdfout = new SimpleDateFormat("yyyyMMdd");

Date d = sdfIn.parse(s);
System.out.println("OLD : " + sdfout.format(d));