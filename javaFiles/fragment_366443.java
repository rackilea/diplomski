String s = "CN=Belzile\\, Pierre,OU=LaptopUser,OU=Users,DC=Company,DC=local";
Pattern p = Pattern.compile("CN=([a-zA-Z]+)\\\\,\\s+([a-zA-Z]+)");
Matcher m = p.matcher(s);

if(m.find()) {
    System.out.println(m.group(1) + " " + m.group(2));
}