@Test
public void test_exception_approach_1() {
    ...
    assertThatExceptionOfType(IOException.class)
            .isThrownBy(() -> someBadIOOperation())
            .withMessage("boom!"); 
}

@Test
public void test_exception_approach_2() {
    ...
    assertThatThrownBy(() -> someBadIOOperation())
            .isInstanceOf(Exception.class)
            .hasMessageContaining("boom");
}

@Test
public void test_exception_approach_3() {
    ...
    // when
    Throwable thrown = catchThrowable(() -> someBadIOOperation());

    // then
    assertThat(thrown).isInstanceOf(Exception.class)
                      .hasMessageContaining("boom");
}