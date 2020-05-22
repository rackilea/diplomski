public class Pair {
    int repetitions;
    String sentence;

    public Pair(int rep, String string){
        repetitions = rep;
        sentence = string;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public String getSentence() {
        return sentence;
    }
}