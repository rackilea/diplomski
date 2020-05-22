String dateString = "2013-05-30T19:30:00+0300";

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
Date date = dateFormat.parse(dateString);

dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
String formatedDate = dateFormat.format(date);

Log.d("Date", formatedDate);