catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.toString());
} finally {
    if(res != null) {
        res.close();
    }
    if(res1 != null) {
        res1.close();
    }
    if(stmt != null) {
        stmt.close();
    }
    if(stmt1 != null) {
        stmt1.close();
    }
    if(conn != null) {
         conn.close();
    }
}