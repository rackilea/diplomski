@JsonCreator
public static ProtocolContainer Create(String jsonString)
{

    ProtocolContainer pc = null;
    try {
        pc = mapper.readValue(jsonString, ProtocolContainer.class);
    } catch (JsonParseException|JsonMappingException|IOException e) {
        // handle
    }

    return pc;
}