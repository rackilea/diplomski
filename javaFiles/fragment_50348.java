public Optional<SomeType> create(final TopClassInHierarchy topClass) {
    Builder builder = new Builder();

    return Optional.of(topClass)
            .filter(tc -> someCondition.evaluate(getFieldOne(tc)))
            .map(this::getFieldTwo)
            .map(builder::withFieldTwo)
            .map(Builder::build);
}