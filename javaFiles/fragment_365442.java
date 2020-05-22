SimpleDateFormat parseFormat = new SimpleDateFormat("M/d/yyyy");
SimpleDateFormat printFormat = new SimpleDateFormat("MM/dd/yyyy");

Date date1 = parseFormat.parse("4/5/2010");
Date date2 = parseFormat.parse("04/05/2010");
String output1 = printFormat.format(date1);
String output2 = printFormat.format(date2);
// output1 and output2 will be the same