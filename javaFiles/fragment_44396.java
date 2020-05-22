PredicateBuilder<Model> to = (fn, value, root, cb) -> {
    Matcher m = getMatcher("to", value);
    if (m.matches()) {
        LocalDate to = LocalDate.parse(m.group(1));
        return Optional.of(cb.lessThanOrEqualTo(root.get(fn), to));
    } else {
        return Optional.empty();
    }
};