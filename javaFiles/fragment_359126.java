String isoInputDatePattern = "yyyy/MM/dd HH:mm:ss";
SimpleDateFormat simpleInputDateFormat = new SimpleDateFormat(isoInputDatePattern);

String isoOutputDatePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
SimpleDateFormat simpleOutputDateFormat = new SimpleDateFormat(isoOutputDatePattern);

Date d = null;
try {
   d = simpleInputDateFormat.parse("2019/04/22 10:04:30");
} catch (ParseException e) {
   e.printStackTrace();
}

String dateString = simpleOutputDateFormat.format(d);
Log.e("dateString ::::> ",dateString);