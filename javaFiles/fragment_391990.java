CriteriaQuery<Bar> query = b.createQuery(Bar.class);

Root<Foo> root = query.from(Foo.class);

query.where(b.equal(root.get("bar").get("id"),"10219431"));
Selection<? extends Bar> join = root.join("Bar",JoinType.INNER);
query.select(join);
Bar b=getEntityManager().createQuery(query).getResultList().get(0);