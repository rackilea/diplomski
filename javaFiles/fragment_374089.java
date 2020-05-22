GlassFish glassfish = new GlassFish(port);
        ScatteredWar war = new ScatteredWar(NAME,
            new File("src/main/resources"),
            new File("src/main/resources/WEB-INF/web.xml"),
            Collections.singleton(new File("build/classes").toURI().toURL()));
        glassfish.deploy(war);