public class Data {
    // Declaring score here makes it an instance variable
    private int score;
    // Giving score a getter lets others access the value,
    // but it does not let them set the new score
    public int getScore() { return score; }
    // test() method can be used to set the score to a specific value
    public void test(){
       score = 100;
    }
}