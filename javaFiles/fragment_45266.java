String rawCookie = request.getHeader("Cookie");
String[] rawCookieParams = rawCookie.split(";");
for(String rawCookieNameAndValue :rawCookieParams)
{
  String[] rawCookieNameAndValuePair = rawCookieNameAndValue.split("=");
}
// so on and so forth.