Set<Class<? extends ZoneId>> zoneClasses = new HashSet<>();
for (ZonedDateTime date : dates) {
    Class<? extends ZoneId> zoneClass = date.getZone().getClass();
    if (zoneClasses.add(zoneClass)) {
        encoder.setPersistenceDelegate(zoneClass, zoneIdDelegate);
    }
}