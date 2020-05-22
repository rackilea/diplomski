PredicateBuilder<Model> between = (fn, value, root, cb) -> {
    Matcher m = getMatcher("between", value, "(.+)\\s*,\\s*(.+)");
    if (m.matches()) {
        LocalDate from = LocalDate.parse(m.group(1));
        LocalDate to = LocalDate.parse(m.group(2));
        return Optional.of(cb.between(root.get(fn), from, to));
    } else {
        return Optional.empty();
    }
};