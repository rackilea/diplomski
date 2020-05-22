static {
    try {

        System.loadLibrary("chilkat");

    } catch (UnsatisfiedLinkError e) {
        System.err.println("Native code library failed to load.\n" + e);
        System.exit(1);
    }
}

// Instantiate a Chilkat object and print it's version.
public static void main(String argv[]) {
    CkZip zip = new CkZip();
    System.out.println(zip.version());
}