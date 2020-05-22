public class Scores {

    // renamed Player to Score, added Comparable
    static class Score implements Comparable<Score> {
        private String name;
        private int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        // and implemented Comparable#compareTo 
        @Override
        public int compareTo(Score that) {
            return Integer.compare(this.score, that.score);
        }
    }


    public static void main(String[] args) {

        var scores = new LinkedList<Score>();
        scores.add(new Score("DOGA", 33));
        scores.add(new Score("Jhol", 34));
        scores.add(new Score("Krish", 25));
        scores.add(new Score("Rama", 25));
        scores.add(new Score("Krish", 21));

        // now we can just order the scores by sorting in reverse order
        Collections.sort(scores, Collections.reverseOrder());
        for (Score score : scores) {
            System.out.println(score.getName());
        }
    }
}