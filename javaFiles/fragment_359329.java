@Test
public void testCheatOnEvilBrotherFight() throws Exception {
    PowerMockito.mockStatic(Illidan.class, defaultAnswer);

    EvilBrother.startFight();
}