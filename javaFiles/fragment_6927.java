//String or File handler to JAR file
    JarFile jar = new JarFile(file);
    Enumeration<JarEntry> entries = jar.entries();

    while (entries.hasMoreElements()) {
        JarEntry jarEntry = entries.nextElement();
        System.out.println(jarEntry.getName() + ": " + jarEntry.isDirectory());
    }

    jar.close();