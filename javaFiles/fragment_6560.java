Connection con = getConnection();
Set<String> ks = ws.keySet();

if (ks.size() > 0) {
    StringBuilder inStatement = new StringBuilder("?");
    for (int i = 1; i < ks.size(); i++) {
        inStatement.append(", ?");
    }

    PreparedStatement ps = con.prepareStatement("select doc_freq from lookup where word in (" + inStatement.toString() + ")");

    int k = 1;
    for (String key : keySet) {
        ps.setString(k++, key);
    }
    ResultSet rs = ps.executeQuery();
}