SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
formatter.setLenient(false);

Date curDate = new Date();
long curMillis = curDate.getTime();
String curTime = formatter.format(curDate);

String oldTime = "05.01.2011, 12:45";
Date oldDate = formatter.parse(oldTime);
long oldMillis = oldDate.getTime();