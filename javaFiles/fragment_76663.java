public class Main {

    public static void main(String[] args) {
        ModuleLayer.boot()                // ModuleLayer
                .configuration()          // Configuration
                .findModule("jdk.jstatd") // Optional<ResolvedModule>
                .orElseThrow()            // ResolvedModule (or throw)
                .reference()              // ModuleReference
                .location()               // Optional<URI>
                .ifPresentOrElse(System.out::println, () -> System.out.println("Location unknown."));
    }

}