ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
provider.addIncludeFilter(new AssignableTypeFilter(Hook.class));
Set<BeanDefinition> definitions = provider.findCandidateComponents("package/name");

Map<String, Hook> hooks = new HashMap<>();
for (BeanDefinition definition : definitions) {
    try {
        Class clazz = Class.forName(definition.getBeanClassName());
        hooks.put(clazz.getSimpleName(), clazz.newInstance());
    } catch (ClassNotFoundException e) {
        logger.error("Unable to get class: ", e);
    }
}