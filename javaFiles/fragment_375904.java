String[] test = Optional.ofNullable(checkList)
    .map(Collection::stream)
    .orElseGet(Stream::empty)
    .findFirst()
    .map(m -> m.get("filename"))
    .filter(f -> !f.trim().isEmpty())
    .map(f -> f.split("_"))
    .orElse(null);