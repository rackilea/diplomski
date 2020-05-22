@Test
public void shouldThrowExceptionOnSave() {
    String newId = "New Test Id";
    String newName = "New Test Name";
    Foo foo = new Foo(newId, newName);

    foo.setName(fooRepository.findById(1 + BASE_ID).get().getName());

    assertThrows(DataIntegrityViolationException.class, () -> {
        fooRepository.save(foo);
        fooRepository.flush();
        // fooRepository.saveAndFlush(foo);
    });
}