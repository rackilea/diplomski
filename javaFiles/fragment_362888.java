changedDate = changedDate.replace("IST ", "");
SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyy");
TimeZone timeZone=TimeZone.getTimeZone("IST");
formatter.setTimeZone(timeZone);

Date date = (Date)formatter.parse(changedDate);