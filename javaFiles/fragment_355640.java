import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import java.io.*;

public class ContextualJsonIdSerializer
    extends JsonSerializer<BaseResource>
    implements ContextualSerializer/*<BaseResource>*/
{
    private ObjectMapper mapper;
    private boolean useJsonId;

    public ContextualJsonIdSerializer(ObjectMapper mapper) { this(mapper, false); }
    public ContextualJsonIdSerializer(ObjectMapper mapper, boolean useJsonId) {
        this.mapper = mapper;
        this.useJsonId = useJsonId;
    }

    @Override
    public void serialize(BaseResource br, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        if ( useJsonId ) {
            jgen.writeString(br.getId().toString());
        } else {
            mapper.writeValue(jgen, br);
        }
    }

    @Override
    public JsonSerializer<BaseResource> createContextual(SerializerProvider config, BeanProperty property)
            throws JsonMappingException
    {
        // First find annotation used for getter or field:
        System.out.println("Finding annotations for "+property);

        if ( null == property ) {
            return new ContextualJsonIdSerializer(mapper, false);
        }

        JsonId ann = property.getAnnotation(JsonId.class);
        if (ann == null) { // but if missing, default one from class
            ann = property.getContextAnnotation(JsonId.class);
        }
        if (ann == null ) {//|| ann.length() == 0) {
            return this;//new ContextualJsonIdSerializer(false);
        }
        return new ContextualJsonIdSerializer(mapper, true);
    }
}