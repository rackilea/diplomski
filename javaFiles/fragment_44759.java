Statement myStmt;

try {
        myStmt = db.createStatement();
        myStmt.executeUpdate(sql);
    } catch (SQLException ex) {
        Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
    }