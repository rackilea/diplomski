@org.junit.Test
public void test() throws Throwable {
    Entity entity = new Entity();

    entity.legacyIndicator = Optional.empty();
    final UUID uuid = UUID.randomUUID();
    entity.newId = Optional.of(uuid);

    String id = getId(entity);
    Assert.assertEquals(uuid.toString(), id);


    entity = new Entity();

    entity.legacyIndicator = Optional.of(Boolean.TRUE);
    entity.newId = Optional.of(uuid);
    entity.legacyId = Optional.of("SomeId");
    id = getId(entity);

    Assert.assertEquals("SomeId", id);
}

@org.junit.Test(expected = IOException.class)
public void testExceptionLegacy() throws Throwable {
    Entity entity = new Entity();

    entity.legacyIndicator = Optional.of(Boolean.TRUE);
    entity.legacyId = Optional.empty();
    String id = getId(entity);
}

@org.junit.Test(expected = IOException.class)
public void testExceptionNew() throws Throwable {
    Entity entity = new Entity();

    entity.legacyIndicator = Optional.empty();
    entity.legacyId = Optional.empty();
    entity.newId = Optional.empty();
    String id = getId(entity);
}

class Entity {
    Optional<Boolean> legacyIndicator;
    Optional<String> legacyId;
    Optional<UUID> newId;

    Optional<Boolean> legacyIndicator() {
        return legacyIndicator;
    }

    Optional<UUID> newId() {
        return newId;
    }

    Optional<String> legacyId() {
        return legacyId;
    }

}