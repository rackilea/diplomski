CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

// Create query
CriteriaQuery<Post> q = cb.createQuery(Post.class)
Root<Post> r = q.from(Post.class);

Predicate[] predicates = new Predicate[2];
predicates[0] = cb.equal(root.get("title"), title);
predicates[1] = cb.equal(root.get("description"), description);

q.select(r).where(predicates);
Query<Post> query = session.createQuery(q);
return query.getSingleResult();