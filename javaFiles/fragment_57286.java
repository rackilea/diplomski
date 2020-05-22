public class OtherClass
{
    private String solution = "HARPS";
    private int wordLength = 5;

    public String getHint(String theGuess) {
        String hint = "";

        for (int index = 0; index < wordLength; index++) {
            if (theGuess.charAt(index) == solution.charAt(index)) {
                hint += theGuess.charAt(index);
            } else if (solution.indexOf(theGuess.charAt(index)) > 0) {
                hint += "+";
            } else {
                hint += "*";
            }
        }

        return hint;
    }
}