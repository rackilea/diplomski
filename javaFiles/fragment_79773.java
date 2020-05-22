public class AppConfigPropertiesConverter
    extends AbstractHttpMessageConverter<List<Config>> {

  public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private Gson gson = null;

  private final GsonBuilder gsonBuilder = new GsonBuilder();

  private final TypeToken<List<Config>> token = new TypeToken<List<Config>>() {};
  /**
   * Construct a new {@code GsonHttpMessageConverter}.
   */
  public AppConfigPropertiesConverter() {
    super(new MediaType("application", "json", DEFAULT_CHARSET), new MediaType(
        "application", "*+json", DEFAULT_CHARSET));
  }

  /**
   * Initializes the type adapters to inorder to deserialize json arrays or json objects.
   */
  public void initializeAdapters() {
   this.gsonBuilder.registerTypeAdapter(token.getType(), new AppConfigDeserializer());
   this.gson = this.gsonBuilder.create();
  }

  /** Supports only {@link L} instances. */
  @Override
  protected boolean supports(Class<?> clazz) {
    // TODO Auto-generated method stub
    return List.class.isAssignableFrom(clazz);
  }

  /**
   * Converts the serialized input to a list of objects.
   * 
   * @param clazz class to be serialized into
   * @param inputMessage message to be read from
   */
  @Override
  protected List<Config> readInternal(
      Class<? extends List<Config>> clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {

    Reader jsonReader =
        new InputStreamReader(inputMessage.getBody(), DEFAULT_CHARSET.displayName());
    return this.gson.fromJson(jsonReader, this.token.getType());
  }

  /**
   * Converts an instance of immutable list to json response.
   * 
   * @param configs list of objects to be serialized
   * @param outputMessage output message to write to
   * @throws IOException thrown if the object can not be serialized
   * @throws HttpMessageNotWritableException if the object can not be written
   */
  @Override
  protected void writeInternal(
      List<Config> configs, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {
    outputMessage.getBody().write(
        this.gson.toJson(
            configs, this.token.getType()).getBytes(DEFAULT_CHARSET.displayName()));
  }
}