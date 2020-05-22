char[] c = new char[]{'H','e','l','l','o','\'',' ','W','o','r','l','d'};
String s = String.valueOf(c);
System.out.println("Before : " + s );

s = s.replaceAll("'", "''");
System.out.println("After : " + s );

char[] c_modified = s.toCharArray();

System.out.println( Arrays.toString(c_modified) );