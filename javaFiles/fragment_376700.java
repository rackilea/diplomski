public static Code loadCode(String Path) {
    Code code;
    try {
        scss = sfactory.openSession();
        scss.beginTransaction();
        String query = "from Code where fileName=\'" + Path + "\'";
        Query queryResult = scss.createQuery(query);
        code = (Code) queryResult.list().get(0);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }