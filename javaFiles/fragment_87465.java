public final class MyEntitySpecifications {
    public static Specification<MyEntity> idsIn(final Collection<Long> ids) {
        return new Specification<MyEntity>() {
            @Override
            public Predicate toPredicate(Root<MyEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return root.get("id").in(ids);
            }
        };
    }
}