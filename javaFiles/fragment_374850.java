/**
 * Treat the given JAR file as a module as follows:
 *
 * 1. The module name (and optionally the version) is derived from the file
 *    name of the JAR file
 * 2. The packages of all .class files in the JAR file are exported
 * 3. It has no module-private/concealed packages
 * 4. The contents of any META-INF/services configuration files are mapped
 *    to "provides" declarations
 * 5. The Main-Class attribute in the main attributes of the JAR manifest
 *    is mapped to the module descriptor mainClass
 */
private ModuleDescriptor deriveModuleDescriptor(JarFile jf)
    throws IOException
{
    // Derive module name and version from JAR file name

    String fn = jf.getName();
    int i = fn.lastIndexOf(File.separator);
    if (i != -1)
        fn = fn.substring(i+1);

    // drop .jar
    String mn = fn.substring(0, fn.length()-4);
    String vs = null;

    // find first occurrence of -${NUMBER}. or -${NUMBER}$
    Matcher matcher = Patterns.DASH_VERSION.matcher(mn);
    if (matcher.find()) {
        int start = matcher.start();

        // attempt to parse the tail as a version string
        try {
            String tail = mn.substring(start+1);
            ModuleDescriptor.Version.parse(tail);
            vs = tail;
        } catch (IllegalArgumentException ignore) { }

        mn = mn.substring(0, start);
    }

    // finally clean up the module name
    mn = cleanModuleName(mn);

    // Builder throws IAE if module name is empty or invalid
    ModuleDescriptor.Builder builder
        = new ModuleDescriptor.Builder(mn)
            .automatic()
            .requires(Set.of(Requires.Modifier.MANDATED), "java.base");
    if (vs != null)
        builder.version(vs);

    // scan the names of the entries in the JAR file
    Map<Boolean, Set<String>> map = VersionedStream.stream(jf)
            .filter(e -> !e.isDirectory())
            .map(JarEntry::getName)
            .collect(Collectors.partitioningBy(e -> e.startsWith(SERVICES_PREFIX),
                                               Collectors.toSet()));

    Set<String> resources = map.get(Boolean.FALSE);
    Set<String> configFiles = map.get(Boolean.TRUE);

    // all packages are exported
    resources.stream()
            .map(this::toPackageName)
            .flatMap(Optional::stream)
            .distinct()
            .forEach(builder::exports);

    // map names of service configuration files to service names
    Set<String> serviceNames = configFiles.stream()
            .map(this::toServiceName)
            .flatMap(Optional::stream)
            .collect(Collectors.toSet());

    // parse each service configuration file
    for (String sn : serviceNames) {
        JarEntry entry = jf.getJarEntry(SERVICES_PREFIX + sn);
        Set<String> providerClasses = new LinkedHashSet<>();
        try (InputStream in = jf.getInputStream(entry)) {
            BufferedReader reader
                = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String cn;
            while ((cn = nextLine(reader)) != null) {
                if (cn.length() > 0) {
                    providerClasses.add(cn);
                }
            }
        }
        if (!providerClasses.isEmpty())
            builder.provides(sn, providerClasses);
    }

    // Main-Class attribute if it exists
    Manifest man = jf.getManifest();
    if (man != null) {
        Attributes attrs = man.getMainAttributes();
        String mainClass = attrs.getValue(Attributes.Name.MAIN_CLASS);
        if (mainClass != null)
            builder.mainClass(mainClass);
    }

    return builder.build();
}

/**
 * Patterns used to derive the module name from a JAR file name.
 */
private static class Patterns {
    static final Pattern DASH_VERSION = Pattern.compile("-(\\d+(\\.|$))");
    static final Pattern NON_ALPHANUM = Pattern.compile("[^A-Za-z0-9]");
    static final Pattern REPEATING_DOTS = Pattern.compile("(\\.)(\\1)+");
    static final Pattern LEADING_DOTS = Pattern.compile("^\\.");
    static final Pattern TRAILING_DOTS = Pattern.compile("\\.$");
}