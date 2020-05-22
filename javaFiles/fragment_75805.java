public List<User> findByUsercardAccount(String account, String email) {
    return userRepository.findAll((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {

        Subquery<User> subquery = criteriaQuery.subquery(User.class);
        Root<Usercard> subRoot = subquery.from(Usercard.class);

        List<Predicate> predicates = new ArrayList<>();
        List<Predicate> subPredicates = new ArrayList<>();

        if (account != null)
            subPredicates.add(criteriaBuilder.equal(subRoot.get("account"), account));

        if (email != null)
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("email"), email)));

        subquery.select(subRoot.get("id")).where(subPredicates.toArray(new Predicate[predicates.size()]));

        predicates.add(criteriaBuilder.exists(subquery));

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    });
}