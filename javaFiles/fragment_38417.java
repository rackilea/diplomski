EntityManager em = [...]
[...]
CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<User> criteria = builder.createQuery(User.class);

Root<User> usersRoot = criteria.from(User.class);
usersRoot.fetch("Address", JoinType.LEFT);

List<User> users = em.createQuery(criteria).getResultList();