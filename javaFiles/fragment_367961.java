public class EmbeddedResponse<T>  {

    @JsonProperty("_embedded")
    @JsonDeserialize( using = EmbeddedResponseDeserializer.class )
    private T embedded;

    public T getEmbedded() {

        return embedded;
    }
}