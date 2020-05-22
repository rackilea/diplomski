@Configuration
public class FeatureConfig implements ApplicationContextAware {
    static boolean needInit = true;

    @Override
    // Register the configuration class into parent context and refreshes all
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        AnnotationConfigWebApplicationContext parent = 
                (AnnotationConfigWebApplicationContext) ((AnnotationConfigWebApplicationContext) ac).getParent();
        if (needInit) { // ensure only one refresh
            needInit = false;
            parent.register(RootConfig.class);
            parent.refresh();
            ((AnnotationConfigWebApplicationContext) ac).refresh();
        }
    }

    @Configuration
    @Conditional(NoParentContext.class)
    // Can only be registered in root context
    public static class RootConfig {
        // configuration to be injected in root context ...
    }

    // special condition that the context is root
    public static class NoParentContext implements Condition {

        @Override
        public boolean matches(ConditionContext cc, AnnotatedTypeMetadata atm) {
            logger.debug(" {} parent {}", cc.getBeanFactory(), cc.getBeanFactory().getParentBeanFactory());
            return (cc.getBeanFactory().getParentBeanFactory() == null);
        }
    }

    // other beans or configuration that normally goes in servlet context
}