public class JarLoader {

    private static final byte[] jarBytes = new byte[] { 0x00 /* .... etc*/ };

    public static void main(String[] args) throws Exception {
        URL.setURLStreamHandlerFactory(new URLStreamHandlerFactory() {
            public URLStreamHandler createURLStreamHandler(String urlProtocol) {
                System.out.println("Someone asked for protocol: " + urlProtocol);
                if ("myjarprotocol".equalsIgnoreCase(urlProtocol)) {
                    return new URLStreamHandler() {
                        @Override
                        protected URLConnection openConnection(URL url) throws IOException {
                            return new URLConnection(url) {
                                public void connect() throws IOException {}
                                public InputStream getInputStream() throws IOException {
                                    System.out.println("Someone is getting my jar!!");
                                    return new ByteArrayInputStream(jarBytes);
                                }
                            };
                        }
                    };
                }
                return null;
            }
        });

        System.out.println("Loading jar with fake protocol!");
        loadJarFromURL(new URL("myjarprotocol:fakeparameter"));
    }

    public static final void loadJarFromURL(URL jarURL) throws Exception {
        URLClassLoader systemClassloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method systemClassloaderMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        systemClassloaderMethod.setAccessible(true);
        systemClassloaderMethod.invoke(systemClassloader, jarURL);

        // This make classloader open the connection
        systemClassloader.findResource("/resource-404");
    }

}