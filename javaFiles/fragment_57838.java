import java.util.HashMap;
            import mypackage.cdi.JSFModule;
            import mypackage.cdi.JsfInjectionProvider;
            import com.google.inject.AbstractModule;
            import com.google.inject.Guice;
            import com.google.inject.Injector;
            import com.google.inject.servlet.GuiceServletContextListener;

            public class GuiceListener extends GuiceServletContextListener {
                protected AbstractModule module;
                protected static Injector injector;
                private static HashMap<String, Object> instancesMap;

                public GuiceListener() {
                    // Bean instance list to ensure that we inject a unique bean instance.
                    instancesMap = new HashMap<>();

                    // Create the injector.
                    injector = Guice.createInjector(new JSFModule());
                }

                @Override
                public Injector getInjector() {
                    return injector;
                }

                /**
                 * given a class, generates an injected instance. Useful when an API call is
                 * needed internally.
                 */
                public static <T> T getInstance(Class<T> type) {
                    return injector.getInstance(type);
                }

                /**
                 * given an injectable instance, injects its dependencies and make sure to
                 * only inject one.
                 */
                public static void injectMembers(Object instance) {
                    Object obj = null;
                    if (JsfInjectionProvider.isBusinessLogicObject(obj)) {
                        String instanceClassName = instance.getClass().getName();
                        Object mappedInstance = instancesMap.get(instanceClassName);
                        if (mappedInstance == null) {
                            // It's a new bean instance. It's stored in the bean map
                            // to be able to reuse it.
                            instancesMap.put(instanceClassName, instance);
                            obj = instance;
                        } else {
                            // There's already a bean instance. Let's reuse it!.
                            obj = mappedInstance;
                        }
                    } else { // it should be a managed bean.
                        obj = instance;
                    }
                    injector.injectMembers(obj);
                }
            }