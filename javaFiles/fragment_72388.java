ClassLoader cl = this.getClass().getClassLoader(); 
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
Resource[] resources = resolver.getResources("classpath:/data/**/*.txt") ;
for (Resource resource: resources){
    logger.info(resource.getFilename());
}