Map<String, Long> summonerIds = new HashMap<String, Long>();
int i = 0;
while (it.hasNext()) {
    JSONObject dash = (JSONObject) it.next();
    summonerIds.put(Character.toString((char) ('a' + i)), (Long) dash.get("summonerId"));
}

System.out.println(summonerIds.get("a")); // 1st
System.out.println(summonerIds.get("c")); // 3rd etc.