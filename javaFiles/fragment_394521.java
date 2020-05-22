// we know what precedes the substring we want
String anchor = "<F_TEXT Encoding=\"unicode\">";
// so we use it to get the start point, looping once, up to that point
int start = textToExtract.indexOf(anchor)+anchor.length();
// we know the end point won't be before the start point, so start where it left off
int end = start;
// count each character from that point until the next XML tag starts
while (textToExtract.charAt(end) != '<') { end++; }
// now we have what we need to simply get the substring
String data = textToExtract.substring(start,end);