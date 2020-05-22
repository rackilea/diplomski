import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class YamlApp {

    public static void main(String[] args) throws Exception {
        File yamlFile = new File("./resource/test.yaml").getAbsoluteFile();

        FleetDeserializer deserializer = new FleetDeserializer();
        Fleet fleet = deserializer.readValue(yamlFile);

        System.out.println(fleet);
    }
}

class FleetDeserializer {
    private YAMLFactory factory = new YAMLFactory();
    private ObjectMapper mapper = new ObjectMapper(factory);

    public Fleet readValue(File yamlFile) throws IOException {
        Fleet fleet = new Fleet();
        fleet.setVehicles(new ArrayList<>());

        YAMLParser parser = factory.createParser(yamlFile);
        while (parser.nextToken() != null) {
            if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
                continue;
            }
            // skip everything until a field name
            while (parser.nextToken() != JsonToken.FIELD_NAME) ;

            Class<? extends Vehicle> type = getType(parser.getCurrentName());
            if (type == null) {
                continue;
            }

            // skip field name
            parser.nextToken();
            parser.nextToken();

            // read next vehicle
            fleet.getVehicles().add(mapper.readValue(parser, type));
        }

        return fleet;
    }

    private Class<? extends Vehicle> getType(String fieldName) {
        Objects.requireNonNull(fieldName);
        switch (fieldName) {
            case "car":
                return Car.class;
            case "truck":
                return Truck.class;
            default:
                return null;
        }
    }
}