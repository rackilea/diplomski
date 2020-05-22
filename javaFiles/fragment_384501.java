public static void main(String[] args) throws ServletException, LifecycleException {
    Tomcat tomcat = new TomcatWithFastJarScanner()
    tomcat.setPort(8080)

    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File("web").getAbsolutePath())

    //declare an alternate location for your "WEB-INF/classes" dir:     
    VirtualDirContext resources = new VirtualDirContext()
    resources.setExtraResourcePaths("/WEB-INF/classes=" + new File("target/classes"))
    ctx.setResources(resources)

    tomcat.start()
    println "Started server on port 8080"
    tomcat.getServer().await()
}

private static class TomcatWithFastJarScanner extends Tomcat {
    @Override
    public void start() throws LifecycleException {
        getServer().findServices().each { service ->
            service.getContainer().findChildren().each { container ->
                container.findChildren().each { c ->
                    ((Context) c).setJarScanner(new FastJarScanner())
                }
            }
        }
        super.start()
    }
}


private static class FastJarScanner extends StandardJarScanner {
    def jarsToInclude = [ 'spring-web.*' ]

    @Override
    public void scan(ServletContext context, ClassLoader classloader,
            JarScannerCallback callback, Set<String> jarsToSkip) {
        jarsToSkip = new HashSet<String>();

        ((URLClassLoader) classloader.getParent()).getURLs().each {
            def jar = it.path.find(/[^\/]+\.jar$/)
            if(!jar) return
            for(String inclusionPattern : jarsToInclude) {
                if(jar.find(inclusionPattern))  
                    println "including jar: " + jar
                else jarsToSkip.add(jar)
            }
        }

        super.scan(context, classloader, callback, jarsToSkip);
    }
}