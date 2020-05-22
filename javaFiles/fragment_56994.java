public class CustomGsonConverter extends GsonConverter {

  private Gson mGson;

  public CustomGsonConverter(Gson gson) {
    super(gson);
    this.mGson = gson;
  }

  public CustomGsonConverter(Gson gson, String encoding) {
    super(gson, encoding);
    this.mGson = gson;
  }

  @Override public Object fromBody(TypedInput body, Type type) throws ConversionException {
    try {
      CustomResponse customResponse = mGson.fromJson(new InputStreamReader(body.in()), CustomResponse.class);
      return mGson.fromJson(customResponse.responseObject.data, type);
    } catch (IOException e) {
      throw new ConversionException(e);
    }
  }

  public static class CustomResponse {

    @SerializedName("rsp") ResponseObject responseObject;

    public static class ResponseObject {

//    @SerializedName("date") long date;

      @SerializedName("data") JsonElement data;

    }

  }

}