String sqlString= "SELECT d.docNumber " +
             + "FROM DOCUMENT d, FS_FILE f " +
             + "WHERE d.docNumber = f.title " +
             + "AND d.date > to_date('01.01.2011','dd.mm.yyyy')"


Query query = em.createNativeQuery(sqlString);
return query.getResultList();