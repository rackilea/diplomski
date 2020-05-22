//fetch all fields without instantiating any models from Hibernate;
//all aliases are for understanding only;
//notice `INNER JOIN c.parent` for fetching the parent data
List<Object[]> results = entityManager.createQuery("SELECT p.id as parentId, p.name as parentName, p.key as parentKey, c.key as childKey FROM Child c INNER JOIN c.parent").getResultList()

//use map for parents identification
Map<Long, Parent> parentsMap = new HashMap<>(results.size())

//now use the data to instantiate the immutable models
results.forEach(resultRecord -> {
    Long parentId = (Long) resultRecord[0];
    if (parentsMap.get(parentId) == null) { //first time meeting this parent
        Parent p = new Parent(resultRecord[0], resultRecord[1], resultRecord[2]);
        parentsMap.put(parentId, p);
    }

    Child c = new Child(parentsMap.get(parentId), resultRecord[3]);
    parentsMap.get(parentId).putChild(c);
}