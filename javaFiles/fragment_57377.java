/**
 * Fix windows 8 warnings by defining a working plugin
 */
static {

    AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
            String os = System.getProperty("os.name", "").trim();
            if (os.startsWith("Windows 8")) {  // 8, 8.1 etc.

                // disable default plugin lookup
                System.setProperty("jinput.useDefaultPlugin", "false");

                // set to same as windows 7 (tested for windows 8 and 8.1)
                System.setProperty("net.java.games.input.plugins", "net.java.games.input.DirectAndRawInputEnvironmentPlugin");

            }
            return null;
        }
    });

}