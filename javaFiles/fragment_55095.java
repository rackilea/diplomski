DateFormat target=new SimpleDateFormat("MMM dd, yyyy");
String P_date="2014-11-18";
Date test1 = new SimpleDateFormat("yyyy-MM-dd").parse(P_date);

String converted_date=target.format(test1);
Date test=target.parse(converted_date);