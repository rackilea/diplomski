@Override
public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    Predicate predicate = null;

    if (StringUtils.isNotBlank(type)) {
        predicate = cb.equal(root.join("documents").get("type"), type);

       cq.where(predicate);
       cq.distinct(true);

      }