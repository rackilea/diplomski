@Test
public void showDifferenceMessage() {
    List<Foo> one = Lists.newArrayList(new Foo(1, "me"));
    List<Foo> two = Lists.newArrayList(new Foo(1, "you"));

    Assert.assertEquals(one, two);
}