String str = "Hi Welcome to my site. #binid:BIN-4 #lat:23.025243 #long:72.5980293 #nottype:assign";
Map<String, String> res = new HashMap<String, String>();
Pattern p = Pattern.compile("#(\\w+):(\\S+)");
Matcher m = p.matcher(str);
while(m.find()) {
    res.put(m.group(1),m.group(2));
    System.out.println(m.group(1) + " - " + m.group(2)); // Demo output
}