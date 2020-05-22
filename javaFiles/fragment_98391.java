@Rule
public ExpectedException exceptionRule = ExpectedException.none();
// ...

@Test
public void shouldThrowALessThanZero_WhenIncorrectA() {
    exceptionRule.expect(ALessThanZeroException.class);
    exceptionRule.expectMessage("A should be greater than 0.");
    // ...
}