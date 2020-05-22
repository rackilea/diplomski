private static final TypeFilter[] ENTITY_TYPE_FILTERS = new TypeFilter[] {
        new AnnotationTypeFilter(Entity.class, false),
        new AnnotationTypeFilter(Embeddable.class, false),
        new AnnotationTypeFilter(MappedSuperclass.class, false)};

private void scanPackages(Configuration conf, String... packagesToScan) throws HibernateException {
        try {
            for (String pkg : packagesToScan) {
                String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                        ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
                Resource[] resources = resourcePatternResolver.getResources(pattern);
                MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        MetadataReader reader = readerFactory.getMetadataReader(resource);
                        String className = reader.getClassMetadata().getClassName();
                        if (matchesFilter(reader, readerFactory)) {
                            conf.addAnnotatedClass(resourcePatternResolver.getClassLoader().loadClass(className));
                        }
                    }
                }
            }
        }
        catch (IOException | ClassNotFouncException ex) {
            throw new MappingException("Failed to scan classpath for unlisted classes", ex);
        }
    }