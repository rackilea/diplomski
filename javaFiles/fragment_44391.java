PredicateBuilder<Model> eq = (fieldName, value, root, cb) -> {
    Matcher m = getMatcher("eq", value);
    if (m.matches()) {
        return Optional.of(cb.equal(cb.upper(root.get(fieldName)), m.group(1).toUpperCase()));
    } else {
        return Optional.empty();
    }
};