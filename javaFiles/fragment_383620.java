import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        System.out.println(mapper.readValue(jsonFile, ContentManagerResponse.class));
    }

}

class ContentManagerResponse {

    private List<OrgSearchResult> results;
    private Map<String, Object> propertiesAndFields;
    private Integer totalResults;
    private String countStringEx;
    private Integer minimumCount;
    private Integer count;
    private Boolean hasMoreItems;
    private String searchTitle;
    private String hitHighlightString;
    private String trimType;
    private Map<String, Object> responseStatus;

    // getters, setters, toString
}

class OrgSearchResult {

    private String trimType;
    private String uri;

    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnySetter
    public void additionalProperties(String name, Object value) {
        additionalProperties.put(name, value);
    }

    // getters, setters, toString
}