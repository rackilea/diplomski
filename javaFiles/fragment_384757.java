import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        String json = "{\"indicator\":\"\"}";

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.ALLOW_COERCION_OF_SCALARS);
        System.out.println(mapper.readValue(json, BaseClass.class));
    }
}

class BaseClass {
    private Boolean indicator;

    public Boolean getIndicator() {
        return indicator;
    }

    public void setIndicator(Boolean indicator) {
        this.indicator = indicator;
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "indicator=" + indicator +
                '}';
    }
}