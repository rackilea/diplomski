interface DBAccess {
    public Result accessDB();
}

class DBOperation {
    static public void DoOperation(DBAccess pAccess) {
        try { return DBAccess.accessDB(); }
        catch(InvalidDBPasswordException IPE) {
             // Do anything about invalid password
        }
        catch(DBConnectionLostException DBCLE) {
             // Do anything about database connection lost
        }
        // Catch all possible DB problem
    }
}

...

private User[] ShowUserList_and_ReturnUsers() {
    // Find the used.

    // Show user list

    if (Users.count() == 0)
         return null;
    else return Users;

    // No need to handle DB connection problem here
}
private User[] GetUserProfile() {
    // Find the used and return
    // No need to handle DB connection problem here
}
...

/** An onClick event to show user list */ {
    DBOperation.DoOperation(new DBAccess() {
        public Result accessDB() {
            return ShowUserList_and_ReturnUsers();
        }
    });
}
/** An onClick event to show a user profile */ {
    DBOperation.DoOperation(new DBAccess() {
        public Result accessDB() {
            return GetUserProfile();
        }
    });
}
... Many more DB access