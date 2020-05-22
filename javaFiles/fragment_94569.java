import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestEntity {
    @SerializedName("kbIdentifier")
    @Expose
    private String kbIdentifier;
    @SerializedName("disambiguationScore")
    @Expose
    private String disambiguationScore;
    public String getKbIdentifier() {
        return kbIdentifier;
    }
    public void setKbIdentifier(String kbIdentifier) {
        this.kbIdentifier = kbIdentifier;
    }
    public String getDisambiguationScore() {
        return disambiguationScore;
    }
    public void setDisambiguationScore(String disambiguationScore) {
        this.disambiguationScore = disambiguationScore;
    }
    @Override
    public String toString() {
        return "BestEntity [kbIdentifier=" + kbIdentifier
                + ", disambiguationScore=" + disambiguationScore + "]";
    }
}