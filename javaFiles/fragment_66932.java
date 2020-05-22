import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class BannerReader {
 private static final String JSON_PATH = "pathToYourJson";

 public BannerData readBanner() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new File(JSON_PATH), BannerData.class);
 }
}