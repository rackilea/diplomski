// Static instance is created at link time
private static SeedGenerator instance;

private static final Debug debug = Debug.getInstance("provider");

final static String URL_DEV_RANDOM = SunEntries.URL_DEV_RANDOM;
final static String URL_DEV_URANDOM = SunEntries.URL_DEV_URANDOM;

// Static initializer to hook in selected or best performing generator
static {
    String egdSource = SunEntries.getSeedSource();

    // Try the URL specifying the source
    // e.g. file:/dev/random
    //
    // The URL file:/dev/random or file:/dev/urandom is used to indicate
    // the SeedGenerator using OS support, if available.
    // On Windows, the causes MS CryptoAPI to be used.
    // On Solaris and Linux, this is the identical to using
    // URLSeedGenerator to read from /dev/random

    if (egdSource.equals(URL_DEV_RANDOM) || egdSource.equals(URL_DEV_URANDOM)) {
        try {
            instance = new NativeSeedGenerator();
            if (debug != null) {
                debug.println("Using operating system seed generator");
            }
        } catch (IOException e) {
            if (debug != null) {
                debug.println("Failed to use operating system seed "
                              + "generator: " + e.toString());
            }
        }
    } else if (egdSource.length() != 0) {
        try {
            instance = new URLSeedGenerator(egdSource);
            if (debug != null) {
                debug.println("Using URL seed generator reading from "
                              + egdSource);
            }
        } catch (IOException e) {
            if (debug != null)
                debug.println("Failed to create seed generator with "
                              + egdSource + ": " + e.toString());
        }
    }

    // Fall back to ThreadedSeedGenerator
    if (instance == null) {
        if (debug != null) {
            debug.println("Using default threaded seed generator");
        }
        instance = new ThreadedSeedGenerator();
    }
}