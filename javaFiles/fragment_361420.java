public class ResourcesFactoryBean implements FactoryBean<Resource[]>{

    @Override
    public Resource[] getObject() {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try{
            resources = patternResolver.getResources("file:" + properties.getPath() + "/*.csv");
        }
        catch(IOException ex){
            LOG.error("The resources must not be null");
        }

        return resources;
    }
   ...