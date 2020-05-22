String input = "2020-01-16T19:44:48.303+0000";

SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+0000'");
inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = inputFormat.parse(input);

SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
// Not needed:  outputFormat.setTimeZone(TimeZone.getDefault());
String output = outputFormat.format(date);

System.out.println("input:  " + input);
System.out.println("output: " + output);
System.out.println(new SimpleDateFormat("zzzz  XX").format(date));