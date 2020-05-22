import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.jaxrs.ext.AbstractSwaggerExtension;
import io.swagger.util.Json;

public class MyExtension extends AbstractSwaggerExtension {

    public MyExtension() {
        final ObjectMapper swaggerMapper = Json.mapper();
        swaggerMapper.registerModule(...);
    }

}