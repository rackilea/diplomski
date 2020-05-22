public static void main(String[] args) throws IOException {
        Set<String> missingMavenData = new HashSet<String>();
        String FOLDER = "/path/to/your/folder/with/jars";

        Files
         .walk(Paths.get(FOLDER), FileVisitOption.FOLLOW_LINKS)
         .map(Path::toFile)
         .filter(f -> f.isFile())
         .filter(f -> f.getName().endsWith(".jar"))
         .map(f -> {
            try {
                return new JarFile(f);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
         })
         .filter(Objects::nonNull)
         .map(jar -> {
             Properties properties = null;
             Enumeration<JarEntry> entries = jar.entries();
             while (entries.hasMoreElements()) {
                 JarEntry jarEntry = entries.nextElement();
                 if (jarEntry.getName().matches("^META-INF/maven/.*/pom\\.properties$")) {
                     try {
                         properties = new Properties();
                         properties.load(jar.getInputStream(jarEntry));
                         break;
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 };
             } 
             if (properties == null) {
                 missingMavenData.add(jar.getName());
             }
             return properties;
         })
         .filter(Objects::nonNull)
         .forEach(properties -> {
            System.out.println("<depencency>");
            System.out.println("    <groupId>" + properties.getProperty("groupId")+ "</groupId>");
            System.out.println("    <artifactId>" + properties.getProperty("artifactId")+ "</artifactId>");
            System.out.println("    <version>" + properties.getProperty("version")+ "</version>");
            System.out.println("</depencency>");
         });

        System.out.println("Those JAR files do not contain Maven metadata:");
        missingMavenData.forEach(System.out::println);
    }