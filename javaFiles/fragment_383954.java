String link = "(?:https|http)://([^\\s\\|]+)";
String pattern = "(?<!\\[video\\])" + link + "(?!\\[video\\])";

Pattern p = Pattern.compile(pattern);
System.out.println(p.matcher("[video]http://www.yahoo.com[video]").matches());
System.out.println(p.matcher("http://www.yahoo.com").matches());