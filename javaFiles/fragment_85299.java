@Test
void test() {
    String words = "AAAA";
    ArrayList<Character> guessLetter = new ArrayList<Character>();
    for (int i = 0; i < words.length(); i++) {
        guessLetter.add(words.charAt(i));

    }
    game game = new game();
    game.setGuessLetter(guessLetter);

    assertEquals(true, game.isRepeated('A'));
}