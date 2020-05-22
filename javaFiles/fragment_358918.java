public class BarTest {
    @Test
    public void testFooIsInitializedProperly() throws Exception {
        // Arrange
        Bar bar = new Bar();

        // Act
        bar.initFoo();

        // Assert
        Foo foo = Whitebox.getInternalState(bar, "foo");
        assertThat(foo, is(notNull(Foo.class)));
    }
}