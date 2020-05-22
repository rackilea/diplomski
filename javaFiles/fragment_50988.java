CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Event> query = cb.createQuery(Event.class);
Root<Event> from = query.from(Event.class);
from.fetch("location", javax.persistence.criteria.JoinType.LEFT);
query.select(from).where(from.get("id").in(1, 2, 3));
TypedQuery<Event> tQuery = entityManager.createQuery(query);
tQuery.setMaxResults(1000);
tQuery.getResultList();