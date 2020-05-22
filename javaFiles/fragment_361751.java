public class SignRepository {

    @Inject
    private SignService signService;

    public SignRepository() {
    }

    public String signRequest(String contentType) {
        return signService.signRequest(contentType);
    }
}