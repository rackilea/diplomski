String timezoneLongName = "";

String fileTimeZone     = "MDT"; //timezone could be anything, getting from file.

Date date            = new Date();
String TimeZoneIds[] = TimeZone.getAvailableIDs();

for (int i = 0; i < TimeZoneIds.length; i++) {

    TimeZone tz   = TimeZone.getTimeZone(TimeZoneIds[i]);
    String tzName = tz.getDisplayName(tz.inDaylightTime(date),TimeZone.SHORT);

    if(fileTimeZone.equals(tzName)){
        timezoneLongName = TimeZoneIds[i];
        break;
    }
}

if(timezoneLongName != null && !timezoneLongName.isEmpty() && !timezoneLongName.trim().isEmpty() && timezoneLongName.length() != 0){
    TimeZone.setDefault(TimeZone.getTimeZone(timezoneLongName));
}