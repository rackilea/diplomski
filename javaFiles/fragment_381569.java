String subject = "d20160812215452p38762620479tincomingmfalse.3gp";
String pattern = "^d([\\d]{14})p([\\d]{11})t([\\w]{8}m[\\w]*\\.3gp)";
Pattern r = Pattern.compile(pattern);

// create a matcher object
Matcher m = r.matcher(subject);
if (m.find( )) {
   System.out.println("Found all: " + m.group(0) );
   System.out.println("Found date: " + m.group(1) );
   System.out.println("Found phone: " + m.group(2) );
   System.out.println("Found title: " + m.group(3) );
} else {
   System.out.println("NO MATCH");
}