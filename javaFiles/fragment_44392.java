PredicateBuilder<Model> like = (fn, value, root, cb) -> {
    Matcher m = getMatcher("like", value);
    if (m.matches()) {
        return Optional.of(cb.like(cb.upper(root.get(fn)), "%" + m.group(1).toUpperCase() + "%"));
    } else {
        return Optional.empty();
    }
};