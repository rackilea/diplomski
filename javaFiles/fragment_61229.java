String sign = secondsFromGMT > 0 ? "+" : "-";
secondsFromGMT = Math.abs(secondsFromGMT);      
int hours = secondsFromGMT/3600;
int mins = (secondsFromGMT%3600)/60;
String zone = String.format("GMT%s%02d:%02d", sign, hours, mins);          
TimeZone t = TimeZone.getTimeZone(zone);