@Test
    public void testQuery() {
        repository.deleteAll();

        Entity entity = Entity.builder()
                .free(true)
                .show(false)
                .name("test")
                .build();
        repository.save(entity);

        List<Entity> entities = repository.findByNameIsNotNullAndShowIsTrueOrFreeIsTrue();

        Assert.assertEquals(1, entities.size());
    }