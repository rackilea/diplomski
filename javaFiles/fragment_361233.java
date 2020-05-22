final List<Predicate> predicates = new ArrayList<Predicate>();

for (final Entry<String, String> e : myPredicateMap.entrySet()) {

    final String key = e.getKey();
    final String value = e.getValue();

    if ((key != null) && (value != null)) {

        if (value.contains("%")) {
            predicates.add(criteriaBuilder.like(root.<String> get(key), value));
        } else {
            predicates.add(criteriaBuilder.equal(root.get(key), value));
        }
    }
}

query.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
query.select(count);