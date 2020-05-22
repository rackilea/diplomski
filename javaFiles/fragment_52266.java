connection =  new URL("http://it.wikipedia.org/wiki/"+word).openConnection();
String ctype = connection.getContentType();
int csi = ctype.indexOf("charset=");
Scanner scanner;
if (csi > 0)
    scanner = new Scanner(new InputStreamReader(connection.getInputStream(), ctype.substring(csi + 8)));
else
    scanner = new Scanner(new InputStreamReader(connection.getInputStream()));
scanner.useDelimiter("\\Z");
content = scanner.next();
if(word.equals("pubblico"))
    System.out.println(content);
System.out.println("Doing: "+ word);