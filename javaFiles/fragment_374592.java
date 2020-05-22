CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
CriteriaQuery<Entry> criteriaQuery = builder.createQuery(Entry.class);
List<Predicate> predicates = new ArrayList<Predicate>();
ParameterExpression<Date> param = builder.parameter(Date.class, "start");
predicates.add(builder.lessThanOrEqualTo(root.get("beforeDate"), param));   criteriaQuery.select(customer)
        .where(predicates.toArray(new Predicate[]{}));
"EntityManagerVariableName".createQuery(cq).getResultList();