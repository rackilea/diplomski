List<Object[]> objList = cdb.getSession().createSQLQuery(sql).list();
 for(Object[] objs : objList){
    int idMagistrado = Integer.valueOf(objs[0]);
    int numeroDemandas = Integer.valuesOf(objs[1]);
    System.out.println(idMagistrado + ":" + numeroDemandas);
 }