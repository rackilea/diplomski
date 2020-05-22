TimeZone local = TimeZone.getTimeZone("Asia/Tokyo");
Calendar now = Calendar.getInstance(local); // gets time in the current timezone
SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
formatter.setTimeZone(local)

String dateString = formatter.format(now.getTime());