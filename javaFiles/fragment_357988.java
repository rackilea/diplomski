import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception  {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(SomeDTOWithLabel.class, IgnoreLabelMixin.class);

        SomeDTOWithLabel dto = new SomeDTOWithLabel();
        dto.setLabel("Hello World");
        dto.setOtherProperty("Other property");
        String json = objectMapper.writeValueAsString(dto);
        System.out.println("json = " + json);
    }

    public static class SomeDTOWithLabel {
        private String label;
        private String otherProperty;

        public String getOtherProperty() {
            return otherProperty;
        }

        public void setOtherProperty(String otherProperty) {
            this.otherProperty = otherProperty;
        }

        public String getLabel() {
            return label;
        }
        public void setLabel(String label) {
            this.label = label;
        }
    }

    public abstract class IgnoreLabelMixin {
        @JsonIgnore
        public abstract String getLabel();

    }
}