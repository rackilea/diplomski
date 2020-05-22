/*
 *  Use SimpleDateFormat.setTimeZone()
 */

String dateString = "2012-11-13 14:00:00:000";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d H:m:s:S");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
Date theDate = sdf.parse(dateString);