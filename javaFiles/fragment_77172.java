public class Util {
    static Supplier<ResourceNotFoundException> notFound(UUID msg) {
        return () -> {
            log.error(msg + " not found");
            return new ResourceNotFoundException(msg + " not found");
        };
    }
}