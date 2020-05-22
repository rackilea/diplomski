DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

DateTime dateTimeWithTimeZone = new DateTime(DateTimeZone.forID("Europe/Vienna")).withDate(2012, 06, 01).withTime(0, 0, 0, 0);      
Date dateWithTimeZoneIncluded = dateTimeWithTimeZone.toLocalDate().toDate();

System.out.println(dateFormat.format(dateWithTimeZoneIncluded));