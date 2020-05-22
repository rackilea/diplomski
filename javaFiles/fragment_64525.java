public void setDao(Dao<ITask, String> dao) {
    this.dao = dao;
}

private Dao<ITask, String> getDao() {
    if (dao != null) {
       // typical ORMLite pattern
       dao = getHelper().getITaskDao();
    }
    return dao;
}