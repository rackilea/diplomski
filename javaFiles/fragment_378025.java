@Test
public void testDifference() throws Exception {
    //given
    List<Integer> left = Lists.newArrayList(1, 2, 3, 4, 5);
    List<Integer> right = Lists.newArrayList(1, 2, 4, 5);

    //when
    List<Integer> result = SetUtils.difference(left, right);

    //then
    assertEquals(Lists.newArrayList(3), result);
}

@Test
public void testDifference2() throws Exception {
    //given
    List<Integer> left = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 9, 10);
    List<Integer> right = Lists.newArrayList(1, 2, 4, 5, 10);

    //when
    List<Integer> result = SetUtils.difference(left, right);

    //then
    assertEquals(Lists.newArrayList(3, 6, 7, 9), result);
}