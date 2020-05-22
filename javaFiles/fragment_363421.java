private Specification<Item> createSpecification(ItemSearch itemSearch) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.and(
            Stream.of(
                    itemSearch.getUsername() == null ? null : criteriaBuilder.like(root.get("username"), itemSearch.getUsername()),
                    itemSearch.getEmail() == null ? null : criteriaBuilder.equal(root.get("email"), itemSearch.getEmail())
            ).filter(Objects::nonNull).toArray(Predicate[]::new)
    );
}