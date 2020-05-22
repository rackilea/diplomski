// First parse string in pattern "yyyy-MM-dd'T'HH:mm:ss'Z'" to date object.
String dateString1 = "2010-03-15T16:34:46Z";
Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateString1);

// Then format date object to string in pattern "MM/dd/yy 'at' h:mma".
String dateString2 = new SimpleDateFormat("MM/dd/yy 'at' h:mma").format(date);
System.out.println(dateString2); // 03/15/10 at 4:34PM