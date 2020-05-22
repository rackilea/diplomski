@Test
public void testCommandAdd() {
    TextBuddy  tb = new TextBuddy ();
    int command tb.parseCommand("add hello");
    assertThat(command,is(TextBuddy.ADD));
}
@Test
public void testCommandRemove() {
    TextBuddy  tb = new TextBuddy ();
    int command tb.parseCommand("remove hello");
    assertThat(command,is(TextBuddy.REMOVE));
}