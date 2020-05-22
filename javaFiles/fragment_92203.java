List<Map<String, Object>> list = new ArrayList<>();
while (strLine = buff.readLine()) != null) {
    s = strLine.split(" ");
    Map<String, String> map = new HashMap<>();
    list.add(map);
    pts = Long.parseLong(s[4].split(":")[1]);
    map.put("pts", pts);
    // Here apply the same logic to the rest
}