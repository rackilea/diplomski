DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale);
df.setTimeZone(User.getTimeZone());
StringBuffer sb = new StringBuffer();
FieldPosition fp = new FieldPosition(DateFormat.MINUTE_FIELD);
sb = df.format(d, sb, fp);
sb.insert( fp.getEndIndex(), new SimpleDateFormat(":ss").format(d) );
String s = sb.toString();