DateTime dt = new DateTime(1355625068295L);

DateTime utc = dt.withZone(DateTimeZone.UTC);
DateTime ny = dt.withZone(DateTimeZone.forID("America/New_York"));
DateTime tk = dt.withZone(DateTimeZone.forID("Asia/Tokyo"));

System.out.println(utc.getMillis() + " is " + utc);
System.out.println(ny.getMillis() + " is " + ny);
System.out.println(tk.getMillis() + " is " + tk);