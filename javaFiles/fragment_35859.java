@JsonDeserialize(using = BodyDeserializer.class)
public class Body<T> {

    @JsonProperty("content")
    private T mContent;

    @JsonProperty("type")
    private String mType;

    @JsonProperty("preview_image_url")
    private String mPreviewImageUrl;

    @JsonProperty("position")
    private int mPosition;

    // getter and setter
}

public class BodyDeserializer extends StdDeserializer<Body> {

    private static final String CAPTION = "caption";
    private static final String CONTENT = "content";
    private static final String COMPLEX = "complex";
    private static final String EMBED_HTML = "embed_html";
    private static final String HEIGHT = "height";
    private static final String PLAYER_TEMPLATE = "player_template";
    private static final String POSITION = "position";
    private static final String PREVIEW_IMAGE_URL = "preview_image_url";
    private static final String PROVIDER = "provider";
    private static final String TYPE = "type";
    private static final String URL = "url";
    private static final String VID = "vid";
    private static final String WATCH_URL = "watch_url";
    private static final String WIDTH = "width";

    public BodyDeserializer() {
        this(Body.class);
    }

    protected BodyDeserializer(Class<Body> vc) {
        super(vc);
    }

    @Override
    public Body deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        final ObjectCodec oc = parser.getCodec();
        final JsonNode node = oc.readTree(parser);

        return deserialize(node);
    }

    private Body deserialize(JsonNode node) {
        final String type = node.get(TYPE).asText();

        if (COMPLEX.equals(type)) {
            return deserializeToBodyWithContent(node, type);
        } else {
            return deserializeToBodyWithString(node, type);
        }
    }

    private Body deserializeToBodyWithString(JsonNode node, String type) {
        final int position = node.get(POSITION).asInt();

        return new Body<String>().setContent(node.get(CONTENT).asText()).setType(type).setPosition(position);
    }

    private Body deserializeToBodyWithContent(JsonNode node, String type) {
        final int position = node.get(POSITION).asInt();
        final String provider = node.get(PROVIDER).asText();
        final String previewImageUrl = node.get(PREVIEW_IMAGE_URL).asText();

        return new Body<Content>().setContent(createContent(node.get(CONTENT)))
                                  .setType(type)
                                  .setProvider(provider)
                                  .setPreviewImageUrl(previewImageUrl)
                                  .setPosition(position);
    }

    private Content createContent(JsonNode node) {
        final int width = node.get(WIDTH).asInt();
        final int height = node.get(HEIGHT).asInt();
        final String vid = node.get(VID).asText();
        final String url = node.get(URL).asText();
        final String caption = node.get(CAPTION).asText();
        final String watchUrl = node.get(WATCH_URL).asText();
        final String embedHtml = node.get(EMBED_HTML).asText();
        final String playerTemplate = node.get(PLAYER_TEMPLATE).asText();

        return new Content().setPlayerTemplate(playerTemplate)
                            .setWidth(width)
                            .setHeight(height)
                            .setUrl(url)
                            .setCaption(caption)
                            .setVid(vid)
                            .setWatchUrl(watchUrl)
                            .setEmbedHtml(embedHtml);
    }
}