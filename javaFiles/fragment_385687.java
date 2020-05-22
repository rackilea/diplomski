MergedTestPropertySources mergedTestPropertySources =
        TestPropertySourceUtils.buildMergedTestPropertySources(testClass);
MergedContextConfiguration mergedConfig = new MergedContextConfiguration(testClass,
        StringUtils.toStringArray(locations),
        ClassUtils.toClassArray(classes),
        ApplicationContextInitializerUtils.resolveInitializerClasses(configAttributesList),
        ActiveProfilesUtils.resolveActiveProfiles(testClass),
        mergedTestPropertySources.getLocations(),
        mergedTestPropertySources.getProperties(),
        contextCustomizers, contextLoader, cacheAwareContextLoaderDelegate, parentConfig);