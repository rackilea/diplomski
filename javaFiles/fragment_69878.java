CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Number> q = cb.createQuery(Number.class);
Root<T> t = q.from(T.class);

// build SUM(A * (100.0 - B) / 100.0) expression
Expression<Double> diff = cb.diff(100.0, t.<Double>get("B"));
Expression<Double> prod = cb.prod(t.<Double>get("A"), diff);
Expression<Number> quot = cb.quot(prod, 100.0);
Expression<Number> sum = cb.sum(quot);
q.select(sum.alias("D"));

System.out.println(em.createQuery(q).getSingleResult());