import static java.lang.System.out;
import static java.security.Provider.Service;
import static java.security.Security.getProviders;
import static java.util.Arrays.stream;

public class ListMessageDigests {
    public static void main(final String... args) {
        stream(getProviders())
            .flatMap(p -> p.getServices().stream())
            .distinct()
            .filter(service -> "MessageDigest".equals(service.getType()))
            .map(Service::getAlgorithm)
            .sorted()
            .forEach(out::println);
    }
}