PredicateBuilder<Model> from = (fn, value, root, cb) -> {
    Matcher m = getMatcher("from", value);
    if (m.matches()) {
        LocalDate from = LocalDate.parse(m.group(1));
        return Optional.of(cb.greaterThanOrEqualTo(root.get(fn), from));
    } else {
        return Optional.empty();
    }
};