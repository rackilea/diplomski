@Test
public void testStatic() {
    //arrange
    when(BusinessUtility.getObject(anyString()))
            .thenReturn("one")
            .thenReturn("two");

    when(BusinessUtility.getObject(any(Date.class), anyBoolean()))
            .thenReturn(new Date(1111))
            .thenReturn(new Date(2222));

    //act
    String firstStr = BusinessUtility.getObject("asdf");
    String secondStr = BusinessUtility.getObject("qwerty");

    Date firstDate = BusinessUtility.getObject(new Date(), true);
    Date secondDate = BusinessUtility.getObject(new Date(), false);

    //assert
    assertThat(firstStr).isEqualTo("one");
    assertThat(secondStr).isEqualTo("two");

    assertThat(firstDate).isEqualTo(new Date(1111));
    assertThat(secondDate).isEqualTo(new Date(2222));
}