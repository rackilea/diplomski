import java.util.SortedSet;
import java.util.TreeSet;

public class Diver {
    private String firstName;
    private String lastName;
    private SortedSet<Double> scores;

    public Diver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
        scores = new TreeSet<>();
    }

    public void addScore(double score) {
        scores.add(score);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getFinalScore() {
        if (scores.size() < 3) {
            return 0.0;
        }
        else {
            double sum = 0.0;
            int counter = 0;
            for(double score : scores) {
                if (counter != 0 && counter != scores.size() - 1) {
                    sum += score;
                }
                counter++;
            }
            return sum;
        }
    }
}