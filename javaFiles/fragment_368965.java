PersistenceDelegate zoneIdDelegate = new PersistenceDelegate() {
    @Override
    protected Expression instantiate(Object target,
                                     Encoder encoder) {
        ZoneId other = (ZoneId) target;
        return new Expression(other, ZoneId.class, "of",
            new Object[] { other.getId() });
    }
};