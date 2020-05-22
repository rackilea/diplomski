// name of the *System* property, takes precedence over PROP_RNDSOURCE
private final static String PROP_EGD = "java.security.egd";
// name of the *Security* property
private final static String PROP_RNDSOURCE = "securerandom.source";

final static String URL_DEV_RANDOM = "file:/dev/random";
final static String URL_DEV_URANDOM = "file:/dev/urandom";

private static final String seedSource;

static {
    seedSource = AccessController.doPrivileged(
            new PrivilegedAction<String>() {

        public String run() {
            String egdSource = System.getProperty(PROP_EGD, "");
            if (egdSource.length() != 0) {
                return egdSource;
            }
            egdSource = Security.getProperty(PROP_RNDSOURCE);
            if (egdSource == null) {
                return "";
            }
            return egdSource;
        }
    });
}