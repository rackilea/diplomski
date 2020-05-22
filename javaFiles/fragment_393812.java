String strCurrentDate = "Wed, 18 Apr 2012 07:55:29 +0000";
SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss Z");
Date newDate = format.parse(strCurrentDate);

format = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
String date = format.format(newDate);