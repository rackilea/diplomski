//lets read data from file
String data=new Scanner(new File("input.txt")).useDelimiter("\\Z").next();

//now lets check how regex will work
Pattern p = Pattern.compile("(int|char)\\s+[a-zA-Z_]\\w*\\s*(?=[;=])");
Matcher m = p.matcher(data);
while(m.find()){
    System.out.println(m.group());
}