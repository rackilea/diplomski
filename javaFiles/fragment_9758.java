public class Score {
    private String userId, score;

    public Score() {}

    public Score(String userId, String score) {
        this.userId = userId;
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "userId='" + userId + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}