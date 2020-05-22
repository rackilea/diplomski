import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class Foo {
    public static void main(final String[] args) throws JsonProcessingException {
        final SomeObject someObject = new SomeObject();
        someObject.setZxy("foobar");

        final ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.PascalCaseStrategy() {
            @Override
            public String nameForGetterMethod(final MapperConfig<?> config, final AnnotatedMethod method, final String defaultName) {
                final JsonProperty annotation = method.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    return annotation.value();
                }
                return super.nameForGetterMethod(config, method, defaultName);
            }
        });
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        System.out.println(mapper.writeValueAsString(someObject));
    }

    private static class SomeObject {

        private String zxy;

        @JsonProperty("abcDef")
        public String getZxy() {
            return this.zxy;
        }

        public void setZxy(final String zxy) {
            this.zxy = zxy;
        }
    }
}