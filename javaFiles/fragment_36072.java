@XmlRootElement
class Response {
    public final List<Rating> ratings;

    public Resonse(List<Rating> ratings) {
        this.ratings = ratings;
    }
}