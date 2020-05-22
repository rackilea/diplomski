final DateTime dt = new DateTime();
// translate to Honolulu local time
final DateTime dtVancouver = dt.withZone(DateTimeZone.forID("Etc/GMT+8"));
final DateTime dtHonolulu = dt.withZone(DateTimeZone.forID("Etc/GMT+10"));
System.out.println(dt);
System.out.println(dtVancouver);
System.out.println(dtHonolulu);