String date = "2013-01-29 11:05:00";

SimpleDateFormat parsedFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
SimpleDateFormat printedFormat = new SimpleDateFormat("HH:mm");
Date a = parsedFormat.parse(date);
System.out.println(printedFormat.format(a));