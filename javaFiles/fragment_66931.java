import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BannerData implements java.io.Serializable {

 private static final long serialVersionUID = 5664846645733319592L;

 @JsonProperty("Banner")
 private String banner;

 public String getBanner() {
     return banner;
 }

 public void setBanner(String banner) {
     this.banner = banner;
 }
}