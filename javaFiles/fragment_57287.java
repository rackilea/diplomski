public class OtherClass
{
    private StringBuilder hint;
    private String solution = "HARPS";
    private int wordLength = 5;

    public String getHint(String theGuess) {
        hint = new StringBuilder();

        for (int index = 0; index < wordLength; index++) {
            if (theGuess.charAt(index) == solution.charAt(index)) {
                hint.append(theGuess.charAt(index));
            } else if(solution.indexOf(theGuess.charAt(index)) > 0) {
                hint.append('+');
            } else {
                hint.append('*');
            }
        }

      return hint.toString();    
    }
}