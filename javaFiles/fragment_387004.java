class RandomWordProvider {   
    String getWord() {
        int randomPosition = randomInteger();
        String randomWord = words.get(randomPosition);
        return randomWord;
    }

    // ...
}

class PlayerCharacterEntry {
    String playerEntry() {
        Scanner characterEntry = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String playerInput = characterEntry.next();
        playerInput = playerInput.toUpperCase();
        return playerInput;
    }
}

class WordGuessingGame2 {
    public static void main(String[] args) {

        // ...

        RandomWordProvider randomWordProvider = new RandomWordProvider();
        PlayerCharacterEntry playerCharacterEntry = new PlayerCharacterEntry();

        randomWordProvider.getWord();
        playerCharacterEntry.playerEntry();
    }
}