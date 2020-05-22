public class UriContainer {

    public UriContainer(URI uri){
        this.uri = uri;
    }
    @NotBlankUri
    private URI uri;

    public URI getUri() {
        return uri;
    }
}

public static void main(String[] args) throws URISyntaxException{
    UriContainer filledContainer = new UriContainer(new URI("Stuff"));
    UriContainer emptyContainer = new UriContainer(new URI(""));
    UriContainer nullContainer = new UriContainer(null);

    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Set<ConstraintViolation<UriContainer>> filledViolations = validator
            .validate(filledContainer);

    Set<ConstraintViolation<UriContainer>> emptyViolations = validator
            .validate(emptyContainer);

    Set<ConstraintViolation<UriContainer>> nullViolations = validator
            .validate(nullContainer);

    System.out.println("Filled: ");
    filledViolations.stream().forEach(System.out::println);
    System.out.println("Empty: ");
    emptyViolations.stream().forEach(System.out::println);
    System.out.println("Null: ");
    nullViolations.stream().forEach(System.out::println);

}