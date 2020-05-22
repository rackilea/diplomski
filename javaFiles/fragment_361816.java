public Predicate toPredicate(Root<EntityAbstract> root, CriteriaQuery<?> query, CriteriaBuilder builder, String value, Expression<?>[] args) {
    Expression<String> function = builder.function("jsonb_extract_path_text",
            String.class, args
    );
    return builder.like(
            function,
            "%" + value + "%"
    );
}