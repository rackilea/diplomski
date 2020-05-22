public class ExcludePackageTypeFilter implements TypeFilter , EnvironmentAware  {

    private Environment env;

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {

        boolean match = false;
        for (String activeProfile : env.getActiveProfiles()) {
            if (activeProfile.equals("dev")) {
                match = isClassInPackage(metadataReader.getClassMetadata(), env.getProperty("devExcludePackage"));
            } else if (activeProfile.equals("prod")) {
                match = isClassInPackage(metadataReader.getClassMetadata(), env.getProperty("prodExcludePackage"));
            }
        }
        return match;
    }

    private boolean isClassInPackage(ClassMetadata classMetadata, String pacakage) {
        return classMetadata.getClassName().startsWith(pacakage);
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}