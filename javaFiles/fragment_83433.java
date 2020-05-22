objectFilter = Collections2.filter(objectFilter, new Predicate<FieldAcceptanceLogItem>() {
    @Override
    public boolean apply(@javax.annotation.Nullable FieldAcceptanceLogItem input) {
        return SublocationFilters.from(mFilters).contains(input.getLocation())
        && TechnologyFilters.from(mFilters).contains(input.getTechnology())
        && ComponentFilters.from(mFilters).contains(input.getComponent());
});