Session session = analyticsSQLSession.getSession();

        try {
            session.beginTransaction();
            Query query =  session.createNativeQuery(tableName("tableName"));
            //query.setParameter("tableName", tableName);


            List resultList = query.getResultList();
            session.close();
            System.out.println();

            return resultList;
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();



public static String tableName(String tableName) {
   return "SELECT * FROM " + tableName;
}