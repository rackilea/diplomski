List l = new ArrayList();
try {
    String sql = "select * from members";
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    while (rs.next()) {
        String con = rs.getString("Contact");
        l.add(con);
    }
} catch (Exception e) {
    e.getMessage();
}
System.out.println(l);