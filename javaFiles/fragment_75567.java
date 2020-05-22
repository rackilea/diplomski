CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> query = cb.createQuery(Integer.class);

Root<Category> r = query.from(Category.class);
Join<Category, Ticket> jT = r.join("tickets")
query.multiselect
(
 cb.construct(A.class, root.get("property1"), root.get("property2"),
 cb.construct(Ticket.class, jT.get("..."))
);
List<Tuple> result = query.getResultList();