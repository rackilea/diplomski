Criteria criteria = session.createCriteria(RevMetadata.class);
criteria.add(Restrictions.eq("entityGUID", GUID));

criteria.setProjection(Projections.projectionList()
                        .add(Projections.property("name"))
                        .add(Projections.property("nameId")));

List<Object[]> criteriaResult = criteria.list();

List<RevMetadata> results = new ArrayList<RevMetadata>();
//then get result into the class properties
for (Object[] object : criteriaResult) {
    //cast to target value type
    String name = (String)object[0];
    int nameId = ((Integer)object[1]).intValue();

    RevMetadata result = new RevMetadata();
    result.setName(name);
    result.setValueId(nameId);

    results.add(result);
}

//now results of List<RevMetadata> is ready