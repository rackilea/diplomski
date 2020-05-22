String selectedTimeStamp = "2016-07-04 21:09:47.6";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
Date parsedDate = sdf.parse(selectedTimeStamp);

System.out.println("parsedDate: " + parsedDate);

Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
System.out.println("createdTime: " +timestamp);