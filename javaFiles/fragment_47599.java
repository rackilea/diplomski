public class NameScoreEntity {
    String name;
    int score;

    public NameScoreEntity(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ", score=" + score;
    }
}