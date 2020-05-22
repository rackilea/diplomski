StringBuilder sql = new StringBuilder("UPDATE league SET season=?");
List<Integer> numValues = new ArrayList<>();
if (l.getPlayedMatches() != -1) {
    sql.append(", playedMatches=?");
    numValues.add(l.getPlayedMatches());
}
if (l.getPercentHomeWins() != -1) {
    sql.append(", percentHomeWins=?");
    numValues.add(l.getPercentHomeWins());
}
// ... more code ...
sql.append(whereClause)
   .append(" and country=?");
try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
    int paramIdx = 0;
    stmt.setInt(++paramIdx, l.getSeason());
    for (Integer numValue : numValues)
        stmt.setInt(++paramIdx, numValue);
    stmt.setString(++paramIdx, l.getCountry());
    stmt.executeUpdate();
}