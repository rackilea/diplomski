// Accept only 10KB of data.
@BodyParser.Of(value = BodyParser.Text.class, maxLength = 10 * 1024)
public static Result index() {
  if(request().body().isMaxSizeExceeded()) {
    return badRequest("Too much data!");
  } else {
    return ok("Got body: " + request().body().asText()); 
  }
}