// Get jarfile url
    String jarUrl = JarVersion.class
        .getProtectionDomain().getCodeSource()
        .getLocation().getFile();

    JarFile jar = new JarFile(new File(jarUrl));
    Manifest manifest = jar.getManifest();
    Attributes attributes = manifest.getMainAttributes();

    String version = attributes.getValue(IMPLEMENTATION_VERSION)