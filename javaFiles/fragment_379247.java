public List<Prod> get(String category, String name, Integer priceMin, Integer priceMax){
    Map<String, Object> paramaterMap = new HashMap<String, Object>();
    List<String> whereCause = new ArrayList<String>();

    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("select p from Prod p ");

    if (!category.isEmpty()){
        whereCause.add(" p.cat.name =:category ");
        paramaterMap.put("category", category);
    }
    if (!name.isEmpty()){
        whereCause.add(" p.name =:name ");
        paramaterMap.put("name", name);
    }
    if (priceMin!=null){
        whereCause.add(" p.price>=:priceMin ");
        paramaterMap.put("priceMin", priceMin);
    }
    if (priceMax!=null){
        whereCause.add("p.price<=:priceMax  ");
        paramaterMap.put("priceMax", priceMax);
    }

    //.................
    queryBuilder.append(" where " + StringUtils.join(whereCause, " and "));
    Query jpaQuery = entityManager.createQuery(queryBuilder.toString());

    for(String key :paramaterMap.keySet()) {
            jpaQuery.setParameter(key, paramaterMap.get(key));
    }

    return  jpaQuery.getResultList();

}