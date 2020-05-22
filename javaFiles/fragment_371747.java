List<Long> summonerIds = new ArrayList<Long>(); // <== list to store summonerIds
while (it.hasNext()) {
    JSONObject dash = (JSONObject) it.next();
    summonerIds.add((Long) dash.get("summonerId")); // <== save 
}

System.out.println(summonerIds.get(0)); // 1st   <== access later
System.out.println(summonerIds.get(2)); // 3rd etc.