@Test
@DisplayName("throws EmptyStackException when peeked")
void throwsExceptionWhenPeeked() {
    Throwable t = assertThrows(EmptyStackException.class, () -> stack.peek());

    Assertions.assertEquals("...", t.getMessage());
}