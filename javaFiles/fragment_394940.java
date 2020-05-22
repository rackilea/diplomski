@Value
@Builder
@JsonDeserialize(builder = PostBody.PostBodyBuilder.class)
public class PostBody {

    byte[] id;

    ClientData clientData;

    public interface IPostBodyBuilder {
        @JsonDeserialize(using = ClientDataBase64Deserializer.class)
        PostBody.PostBodyBuilder clientData(ClientData clientData);
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class PostBodyBuilder implements IPostBodyBuilder {}
}


class ClientDataBase64Deserializer extends StdScalarDeserializer<ClientData> {
    private final ObjectMapper objectMapper;

    protected ClientDataBase64Deserializer(ObjectMapper objectMapper) {
        super(ClientData.class);
        this.objectMapper = objectMapper;
    }

    @Override
    public ClientData deserialize(
            JsonParser jsonParser, DeserializationContext deserializationContext
    ) {
        byte[] value = jsonParser.readValueAs(byte[].class);
        return objectMapper.readValue(value, ClientData.class);
    }
}