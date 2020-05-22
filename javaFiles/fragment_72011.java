public class Field {
    private String description;
    private double weight;  
    private double score;

    public Field(String description, double weight, double score) {
        this.description = description;
        this.weight = weight;
        this.score = score;
    }
    public double getFinalScore() {
        return score * weight;
    }
    // other getter/setters as needed
}