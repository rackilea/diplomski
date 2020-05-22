private void enableAnnotationScanning(Server server)
{
    Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
    classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
            "org.eclipse.jetty.annotations.AnnotationConfiguration");
}