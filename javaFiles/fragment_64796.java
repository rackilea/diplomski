Integer kills = 0;
if(members.size() > 0) {
    StringBuilder sql = new StringBuilder("SELECT SUM(kills) FROM Stats WHERE player in (?");
    for(int index = 1; index < members.size(); index++) {
        sql.append(",?");
    }
    sql.append(")");
    try {
        final PreparedStatement sel = conn.prepareStatement(sql.toString());
        for (int index = 0; index < members.size(); index++) {
            sel.setString(index + 1, members.get(index));
        }
        final ResultSet rs = sel.executeQuery();
        kills = rs.getRow() != 0 ? rs.getInt(1) : 0;
    } catch (final SQLException e) {
        e.printStackTrace();
    }
}