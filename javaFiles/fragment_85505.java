Configuration.ClassList classlist = Configuration.ClassList
            .setServerDefault( server );
    classlist.addAfter(
            "org.eclipse.jetty.webapp.FragmentConfiguration",
            "org.eclipse.jetty.plus.webapp.EnvConfiguration",
            "org.eclipse.jetty.plus.webapp.PlusConfiguration");

    classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                        "org.eclipse.jetty.annotations.AnnotationConfiguration");