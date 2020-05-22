Set<Style> releaseStyles = em.find(Release.class, release_id).getStyles();

CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Release> query = cb.createQuery(Release.class);
Root<Release> root = query.from(Release.class);
List<Predicate> predicates = new ArrayList<Predicate>();

Expression<Integer> key = root.get("id");
Expression<Set<Style>> field = root.get("styles");

for (Style style : releaseStyles) {
  predicates.add(cb.isMember(cb.literal(style), field));
}

query.select(root).where(cb.and(
  cb.or(predicates.toArray(new Predicate[0])),
  cb.notEqual(key, release_id)
));

query.distinct(true);
query.groupBy(key);

return em.createQuery(query).getResultList();