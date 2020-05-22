SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.");
String s = "2005-02-25 11:50:11.579410";
java.sql.Timestamp ts = java.sql.Timestamp.valueOf(s);
int microFraction = ts.getNanos() / 1000;

StringBuilder sb = new StringBuilder(fmt.format(ts));
String tail = String.valueOf(microFraction);
for (int i = 0; i < 6 - tail.length(); i++) {
    sb.append('0');
}
sb.append(tail);
System.out.println(sb.toString());