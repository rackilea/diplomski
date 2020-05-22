import java.util.regex.*;

final Pattern p = Pattern.compile("<name>(.+?)</name>");
final Matcher m = p.matcher("<name>any string you want to retrieve</name>");
m.find();
System.out.println(m.group(1));