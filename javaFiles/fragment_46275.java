public class Game {

    public static void main(String[] args) {

        int count = 1;

        List<String> words = new ArrayList<>();
        words.add("ruby");
        words.add("python");
        words.add("swift");

        for (String word : words) {

            System.out.println("Let's play a round of " + count + "hangman.");
            System.out.println("We are playing hangman");

            Hangman game = new Hangman();

            game.nextRound(word);

            while (true) {
                System.out.println("");
                System.out.println("The disguised word is " + game.disguised());
                System.out.println("Guess a letter:");
                char guess = kb.next().charAt(0);
                boolean isFound = game.guessLetter(guess);
                if (isFound) {
                    game.result();
                    if (game.disguised().equals(game.secret())) {
                        game.found();
                        break;
                    }
                } else {
                    game.result();
                }
            }
            count++;
        }
    }
}