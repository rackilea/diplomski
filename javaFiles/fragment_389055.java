HashMap<Integer, Match> matchMap = new HashMap<>();

for(Match m : currentDayMatchList) {
    int id = m.getMatchId().intValue()
    matchMap.put(id, m);
}