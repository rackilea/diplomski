String input = "!Women Art Revolution (2010) |   3 stars, 1hr 22m";

// mind the extra escaping of \ char because of Java string literal escaping
Pattern p = Pattern.compile("^!(.*) \\((\\d*)\\) *\\| *([\\d.]*) *stars,.*$");  
Matcher m = p.matcher(input);
System.out.println("matches? " + m.matches());
System.out.println("name: " + m.group(1));
System.out.println("name: " + m.group(2));
System.out.println("name: " + m.group(3));