public interface HangManModel {

    public void addGuess(char guess);

    public char[] getGuesses();
    public String getSecretWord();
    public int getState(); // running, win or lose

    public void addChangeListener(ChangeListener listener);
    public void removeChangeListener(ChangeListener listener);

}