public class TestMethodScope implements Scope {
    public static final String NAME = "testMethod";

    private Map<String, Object> scopedObjects = new HashMap<>();
    private Map<String, Runnable> destructionCallbacks = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }
        return scopedObjects.get(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object remove(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    public static class TestExecutionListener implements org.springframework.test.context.TestExecutionListener {

        @Override
        public void afterTestMethod(TestContext testContext) throws Exception {
            ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) testContext
                    .getApplicationContext();
            TestMethodScope scope = (TestMethodScope) applicationContext.getBeanFactory().getRegisteredScope(NAME);

            scope.destructionCallbacks.values().forEach(callback -> callback.run());

            scope.destructionCallbacks.clear();
            scope.scopedObjects.clear();
        }
    }

    @Component
    public static class ScopeRegistration implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
            factory.registerScope(NAME, new TestMethodScope());
        }
    }

}