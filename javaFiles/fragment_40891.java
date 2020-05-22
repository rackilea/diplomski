Connection conn = DataBase.getConnection();
PreparedStatement s = conn.prepareStatement(query.toString());

if (par1 != null || par2 != null || par3 != null) {
    int n = 1;
    if (par1 != null) {
        s.setString(n++, par1);
    }
    if (par2 != null) {
        s.setString(n++, par2);
    }
    if (par3 != null) {
        s.setString(n, par3);
    }
}