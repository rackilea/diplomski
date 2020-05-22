Specification<S> specification = (root, query, cb) -> {
  Join i18nJoin = root.join(collectionName, JoinType.LEFT);
  Join i18nDefaultJoin = root.join(collectionName, JoinType.LEFT);

  i18nJoin.on(cb.equal(i18nJoin.get("languageId"), 22));
  i18nDefaultJoin.on(cb.equal(i18nDefaultJoin.get("languageId"), 1));

  ... where clause and return ...
}