import javax.faces.webapp.FacesServlet;
            import javax.inject.Singleton;

            import mypackage.cdi.annotation.ViewScoped;
            import mypackage.cdi.annotation.ViewScopedImpl;
            import mypackage.cdi.listener.PostConstructTypeListener;
            import mypackage.jsf.FacesHttpServlet;
            import com.google.inject.matcher.Matchers;
            import com.google.inject.servlet.ServletModule;

            public class JSFModule extends ServletModule {
                private void businessLogicBindings() {
                    bind(InjectorConstants.VISITS_HANDLER).toInstance(InjectorConstants.VISITS_HANDLER_IMPL);
                }

                private void systemBindings() {
                    // Add support for the @PostConstruct annotation for Guice-injected
                    // objects.
                    bindListener(Matchers.any(), new PostConstructTypeListener(null));

                    // Binding a custom implementation of "@ViewScoped" scope.
                    bindScope(ViewScoped.class, new ViewScopedImpl());
                }

                private void jsfBindings() {
                    // Define and bind FacesServlet as singleton object
                    // so it can be injected in FacesHttpServlet's constructor.
                    bind(FacesServlet.class).in(Singleton.class);

                    // JSF patterns to be served by FacesHttpServlet.
                    for (String urlPattern : InjectorConstants.JSF_SERVLET_URL_PATTERNS) {
                        serve(urlPattern).with(FacesHttpServlet.class);
                    }
                }

                @Override
                protected void configureServlets() {
                    // Guice injector bindings.
                    this.systemBindings();
                    this.businessLogicBindings();
                    this.jsfBindings();
                }
            }