String s = "!\nmap-class frame-relay TempMap_1\n frame-relay cir 1536000\n frame-relay bc 15360\n frame-relay mincir 281000\n frame-relay adaptive-shaping becn\n service-policy output AB_TEMP_F1536K_0-256K-384K-128K_18\nlogging trap debugging\nlogging source-interface Loopback1\nlogging 136.91.111.21";
Pattern p = Pattern.compile("map-class frame-relay TempMap_1.*(?:\\R\\h+.*)*");
Matcher m = p.matcher(s);
List<String> res = new ArrayList<>();
while(m.find()) {
    res.add(m.group());
}
System.out.println(res);