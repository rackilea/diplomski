@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private String id;            // map from '"id": "770672122"'
    private String title;         // map from '"title": "Toy Story 3"'
    private Integer year;
    @JsonProperty("mpaa_rating")
    private String mpaaRating;
    private Integer runtime;
    @JsonProperty("release_dates")
    private Release released;     // another object mapping!
}