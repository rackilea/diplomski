@ApplicationScoped
public class PerformSetup implements Extension {

    Map<String, String> configMap;

    public PerformSetup() {
        configMap = new HashMap<String, String>();
        // This is a dummy initialization, do something constructive here
        configMap.put("string.value", "This is a test value");
    }

    // Add the ConfigMap values to the global bean scope
    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager bm) {
        // Loop through each entry registering the strings.
        for (Entry<String, String> configEntry : configMap.entrySet()) {
            final String configKey = configEntry.getKey();
            final String configValue = configEntry.getValue();

            AnnotatedType<String> at = bm.createAnnotatedType(String.class);
            final InjectionTarget<String> it = bm.createInjectionTarget(at);

            /**
             * All of this is necessary so WELD knows where to find the string,
             * what it's named, and what scope (singleton) it is.
             */ 
            Bean<String> si = new Bean<String>() {

                public Set<Type> getTypes() {
                    Set<Type> types = new HashSet<Type>();
                    types.add(String.class);
                    types.add(Object.class);
                    return types;
                }

                public Set<Annotation> getQualifiers() {
                    Set<Annotation> qualifiers = new HashSet<Annotation>();
                    qualifiers.add(new NamedAnnotationImpl(configKey));
                    return qualifiers;

                }

                public Class<? extends Annotation> getScope() {
                    return Singleton.class;
                }

                public String getName() {
                    return configKey;
                }

                public Set<Class<? extends Annotation>> getStereotypes() {
                    return Collections.EMPTY_SET;
                }

                public Class<?> getBeanClass() {
                    return String.class;
                }

                public boolean isAlternative() {
                    return false;
                }

                public boolean isNullable() {
                    return false;
                }

                public Set<InjectionPoint> getInjectionPoints() {
                    return it.getInjectionPoints();
                }

                @Override
                public String create(CreationalContext<String> ctx) {
                    return configValue;

                }

                @Override
                public void destroy(String instance,
                        CreationalContext<String> ctx) {
                    // Strings can't be destroyed, so don't do anything
                }
            };
            abd.addBean(si);
        }
    }

    /**
     * This is just so we can create a @Named annotation at runtime.
     */
    class NamedAnnotationImpl extends AnnotationLiteral<Named> implements Named {
        final String nameValue;

        NamedAnnotationImpl(String nameValue) {
            this.nameValue = nameValue;
        }

        public String value() {
            return nameValue;
        }

    }
}