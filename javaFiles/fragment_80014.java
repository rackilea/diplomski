/*
 *  Add the TimeZone info to the end of the date:
 */

String dateString = "2012-11-13 14:00:00:000";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d H:m:s:S Z");
Date theDate = sdf.parse(dateString + " UTC");