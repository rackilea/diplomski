String date = finalObject.getString("DateCreated");

String temp = date.substring(date.indexOf("(") + 1);
String datereip = date.substring(0, date.indexOf(")"));

Long timeInMillis = Long.parseLong(datereip);
Date date1=new Date(timeInMillis);