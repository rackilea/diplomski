import com.fasterxml.jackson.annotation.JsonValue;

public enum ReviewersRating {
    _0(0),_1(1), _2(2), _3(3), _4(4), _5(5);

    private final int rating;
    private ReviewersRating(final int rating) {
        this.rating = rating;
    }

    @JsonValue
    public int toInt()
    {
        return this.rating;
    }
}