@Validated
public interface HelloOperations {

  @Post(value = "/helloBody/{name}", consumes = MediaType.TEXT_PLAIN)
  Single<String> helloBody(@NotBlank String name, @NotBlank @Body String text);
}