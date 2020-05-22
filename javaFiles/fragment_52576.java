String[] stuffsplit = stuff.split("<type>locality");
String firstHalf = stuffsplit[0];  // keep everything before that

// now look for the short_name tags at the end of this
int start = firstHalf.lastIndexOf("<short_name>") + "<short_name>".length();
int end = firstHalf.lastIndexOf("</short_name>");
String name = firstHalf.substring(start, end);