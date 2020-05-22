import javax.xml.bind.annotation.XmlAttribute;

public class Movie {
    @XmlAttribute
    private String plot;

    @XmlAttribute
    private String imdbRating;

    public String getPlot() {
        return plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }
}