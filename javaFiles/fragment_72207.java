public class WebShopErrorDecoder implements ErrorDecoder {

  private final ResponseEntityDecoder decoder;

  public WebShopErrorDecoder(ResponseEntityDecoder decoder) {
    this.decoder = decoder;
  }

  @Override
  public Exception decode(String methodKey, Response response) {
    try {
        ErrorResource error = (ErrorResource) decoder.decode(response, ErrorResource.class);

        return new EShopRequestException(error, HttpStatus.valueOf(response.status()));
    } catch (IOException e) {

        return new EShopRequestException(new ErrorResource("error.internal", "Internal server error"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}