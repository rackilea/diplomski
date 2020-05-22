InputStream reader = null;
for (URL url : ((URLClassLoader) (Thread.currentThread()
        .getContextClassLoader())).getURLs()) {
    if (url.getPath().contains("notification-engine")) {
        String inputFile = "jar:file:" + url.getPath()
                + "!/META-INF/spring/beans.xml";
        URL inputURL = null;
        try {
            inputURL = new URL(inputFile);
            JarURLConnection conn = (JarURLConnection) inputURL
                    .openConnection();
            reader = conn.getInputStream();
        } catch (MalformedURLException e1) {
            System.err.println("Malformed input URL: " + inputURL);
        } catch (IOException e1) {
            System.err.println("IO error open connection");
        }
        break;
    }

}