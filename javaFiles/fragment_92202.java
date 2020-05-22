Map<String, List<Object>> map = new HashMap<>();
...
while (strLine = buff.readLine()) != null) {
    s = strLine.split(" ");
    pts = Long.parseLong(s[4].split(":")[1]);
    List<String> listPts = map.get("pts");
    if (listPts == null) {
        listPts = new ArrayList<>();
        map.put("pts", listPts);
    }
    listPts.add(pts);
    // Here apply the same logic to the rest
}