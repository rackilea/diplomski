import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Root root = mapper.readValue(jsonFile, Root.class);
        root.getData().forEach(s -> s.setfHash(UUID.randomUUID().toString()));

        System.out.println(mapper.writeValueAsString(root));
    }
}

class Root {
    private List<UASchema> data;

    public List<UASchema> getData() {
        return data;
    }

    public void setData(List<UASchema> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Root{" +
                "data=" + data +
                '}';
    }
}

class UASchema {

    @JsonProperty("metric_id")
    private List<String> fMetricId;

    @JsonProperty("schema")
    private List<String> fSchema;

    @JsonProperty("hash")
    private String fHash;

    public List<String> getfMetricId() {
        return fMetricId;
    }

    public void setfMetricId(List<String> fMetricId) {
        this.fMetricId = fMetricId;
    }

    public List<String> getfSchema() {
        return fSchema;
    }

    public void setfSchema(List<String> fSchema) {
        this.fSchema = fSchema;
    }

    public String getfHash() {
        return fHash;
    }

    public void setfHash(String fHash) {
        this.fHash = fHash;
    }

    @Override
    public String toString() {
        return "UASchema{" +
                "fMetricId=" + fMetricId +
                ", fSchema=" + fSchema +
                ", fHash='" + fHash + '\'' +
                '}';
    }
}