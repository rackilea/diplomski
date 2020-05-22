@Test
public void testThatOptionalIsNotEmpty() {
    assertThat(testedMethod()).isNotEmpty();
}

@Test
public void testThatOptionalHasValue() {
    assertThat(testedMethod()).hasValue("hello");
}