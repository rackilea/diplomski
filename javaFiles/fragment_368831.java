public List<Tableof> getResultList() {
    List<Tableof> list = new ArrayList<Tableof>()
    ResultSet rs = stmt.executeQuery(query);
    while (!rs.islast()) {
        rs.next();
        Tableof tableof = (Tableof) rs.getObject();
        list.add(tableof)
    }
    return list;
}