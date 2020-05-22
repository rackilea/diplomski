public List<User> getReport(String name, Integer age, String sName, Date bd, 

 String address, String msg2, int first, int pageSize) {

    Map<String, Object> paramaterMap = new HashMap<String, Object>();
    List<String> whereCause = new ArrayList<String>();

    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("select u from User u ");

    if (!name.isEmpty()){
        whereCause.add(" u.name =:name ");
        paramaterMap.put("category", category);
    }
    if (age != null){
        whereCause.add(" u.age =:age ");
        paramaterMap.put("age", age);
    }
   if (!sName.isEmpty()){
        whereCause.add(" u.sName =:sName ");
        paramaterMap.put("sName", sName);
    }
    if (bd != null){
        whereCause.add(" u.bd =:bd ");
        paramaterMap.put("bd", bd);
    }
    if (!address.isEmpty()){
        whereCause.add(" u.address =:address ");
        paramaterMap.put("address", address);
    }
   if (!msg2.isEmpty()){
        whereCause.add(" u.msg2 =:msg2 ");
        paramaterMap.put("msg2", msg2);
    }

    queryBuilder.append(" where " + StringUtils.join(whereCause, " and "));
    Query jpaQuery = entityManager.createQuery(queryBuilder.toString());

    for(String key :paramaterMap.keySet()) {
            jpaQuery.setParameter(key, paramaterMap.get(key));
    }

    jpaQuery.setFirstResult(first)
    jpaQuery.setMaxResults(pageSize)

    return  jpaQuery.getResultList();
}