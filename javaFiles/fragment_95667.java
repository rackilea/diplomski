public class EntityNotFoundException extends RuntimeException {

    private final String fallbackView;

    public EntityNotFoundException(final String fallbackView) {
        this.fallbackView = fallbackView;
    }

    public String getFallbackView() {
        return fallbackView;
    }