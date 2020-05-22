@JacksonXmlRootElement
public static class XmlData
{
    @JsonProperty("attributes")
    @JsonDeserialize(using = XmlAttributesDeserializer.class)  // specify different serializer
    @JsonSerialize(using = XmlAttributesSerializer.class)  // specify different deserializer
    @JacksonXmlElementWrapper
    public Map<Key, Map<String, Attribute>> attributes;
}