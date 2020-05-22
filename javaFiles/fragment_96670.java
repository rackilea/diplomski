Pattern p = Pattern.compile("(AM)");
Matcher m = p.matcher(time);
StringBuffer sb = new StringBuffer(); 
while(m.find()) {
    m.appendReplacement(sb, "AM ET");
    } 
m.appendTail(sb); 
p = Pattern.compile("(PM)");
m = p.matcher(sb.toString()); // CHANGED
sb = new StringBuffer(); // ADDED
while(m.find()) {
    m.appendReplacement(sb, "PM ET");
    } 
m.appendTail(sb); 

System.out.println("sb: " + sb);