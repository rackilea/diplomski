public Thing getThingById(long id) {
    try {
        ResultSet rs = queryDatabase("SELECT * FROM THING WHERE ID = " + id);
        rs.next();
        return new Thing(rs.get(1), rs.get(2), rs.get(3));
    } catch (Exception e) {
        return null;
    }
}