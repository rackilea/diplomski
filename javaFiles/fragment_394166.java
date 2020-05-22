CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Notification> cq = criteriaBuilder.createQuery(Notification.class);
Metamodel m = entityManager.getMetamodel();
EntityType<Notification> Notification_ = m.entity(Notification.class);

Root<Notification> root = cq.from(Notification_);

Expression<String> exp1 = criteriaBuilder.upper(root.<String>get("status"));

Predicate predicate1 = criteriaBuilder.like(emp1, "START");
Predicate predicate2 = criteriaBuilder.like(emp1, "PAUSED");
Predicate predicate3 = criteriaBuilder.like(emp1, "RUNNING");
Predicate predicate4 = criteriaBuilder.like(emp1, "END_ERROR");
Predicate predicate5 = criteriaBuilder.like(emp1, "END_SUCCESS");

Predicate predicate = criteriaBuilder.or(predicate1, predicate2, predicate3, predicate4, predicate5)
cq.where(predicate);
cq.orderBy(criteriaBuilder.desc(root.get("date")));

Query query = entityManager.createQuery(cq);
query.setMaxResults(n);
return query.getResultList();