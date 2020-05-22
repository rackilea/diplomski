public List<String> low() {
    ArrayList<String> items = new ArrayList<>();
    try {
        ResultSet rs = Database.getConnection().executeQuery("SELECT name FROM detail WHERE qty<=100");
        while (rs.next()) {
            items.add(rs.getString("name"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return items;
}