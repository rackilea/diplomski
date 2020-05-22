List<Class> classes = new LinkedList<Class>();
PathMatchingResourcePatternResolver scanner = new 
    PathMatchingResourcePatternResolver();
// this should match the package and the class name. for example "*.Bar"
Resource[] resources = scanner.getResources(matchPattern); 

for (Resource resource : resources) {
    Class<?> clazz = getClassFromFileSystemResource(resource);
    classes.add(clazz);
}


public static Class getClassFromFileSystemResource(Resource resource) throws Exception {
    String resourceUri = resource.getURI().toString();
    // finding the fully qualified name of the class
    String classpathToResource = resourceUri.substring(resourceUri
            .indexOf("com"), resourceUri.indexOf(".class"));
    classpathToResource = classpathToResource.replace("/", ".");
    return Class.forName(classpathToResource);
}