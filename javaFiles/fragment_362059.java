private void setupDB() {
    dbAccess = new DBAccess(this);
    dbAccess.openDB();
}

:

private void searchDB() {
    :

    mStatusList = dbAccess.selectAllStatus();

    :
}

:
: