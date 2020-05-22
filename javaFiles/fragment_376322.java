CriteriaBuilder b = em.getCriteriaBuilder();
CriteriaQuery<Tuple> c = b.createTupleQuery();
Root<EntityX> entityXRoot= c.from(EntityX.class);
Root<EntityY> entityYRoot = c.from(EntityY.class);

List<Predicate> predicates = new ArrayList<>();
//Here you need to add the predicates you need

List<Predicate> andPredicates = new ArrayList<>();
andPredicates.add(b.equal(entityXRoot.get("id"), entityYRoot.get("id")));
andPredicates.add(b.and(predicates.toArray(new Predicate[0])));

c.multiselect(entityXRoot, entityYRoot);
c.where(andPredicates.toArray(new Predicate[0]));

TypedQuery<Tuple> q = em.createQuery(criteria);

List<Tuple> result = q.getResultList();