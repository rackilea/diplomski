Connection con = null;
PreparedStatement ps = null;
try {
    // your code here.
    ps.execute();
    con.commit();
} catch (Exception e){

} finally {
    closeResource(ps)
    closeResource(con);
}