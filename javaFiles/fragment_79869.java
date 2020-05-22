public class StandardStopperCustom extends StandardStopper {
    @Override
    public void processBinding(Node node, App app) throws Exception {
        ContextHandler handler;
        try {
            handler = app.getContextHandler();

            if (handler instanceof WebAppContext) {
                WebAppContext webapp = (WebAppContext) handler;

                File tempDirectory = (File) webapp.getAttribute("javax.servlet.context.tempdir");
                String baseDirectory = tempDirectory.getName();

                if (webapp.getClassLoader() instanceof WebAppClassLoaderCustom && !baseDirectory.isEmpty()) {
                    WebAppClassLoaderCustom classLoader = (WebAppClassLoaderCustom) webapp.getClassLoader();

                    super.processBinding(node, app);

                    classLoader.close();
                    cleanUpTempDirectory(baseDirectory);
                }
            } else {
                super.processBinding(node, app);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void cleanUpTempDirectory(String tempDirectory) {
        File work = new File(Constantes.workDirectory);

        File[] jettyFolders = work.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.equalsIgnoreCase(tempDirectory)) {
                    return true;
                }

                return false;
            }
        });

        if (jettyFolders != null && jettyFolders.length > 0) {
            for (File file : jettyFolders) {
                IO.delete(file);
            }
        }
    }
}