String pattern = "<td>\\$&.+;(\\d{1,4}\\.\\d{2})&";
Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(inputLine);

if (m.find( )) {
     System.out.println("Price: $" + m.group(1) );
}