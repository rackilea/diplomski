@Test
public void shouldThrowExceptionOnSave() {
    String newId = "New Test Id";
    String newName = "New Test Name";
    Foo foo = new Foo(newId, newName);

    foo.setName(fooRepository.findById(1 + BASE_ID).get().getName());

    PersistenceException exception = assertThrows(PersistenceException.class, () -> {
        fooRepository.save(foo);
        testEntityManager.flush();
    });

    assertTrue(exception.getCause() instanceof ConstraintViolationException);
}