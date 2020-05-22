import mypackage.jsf.logic.VisitsHandler;
            import mypackage.jsf.logic.impl.VisitsHandlerImpl;
            interface InjectorConstants {

                // Url patterns for FacesServlet, as it would be defined in web.xml
                static String[] JSF_SERVLET_URL_PATTERNS = new String[] { "*.jsf", "*.xhtml" };

                // BUSINESS LOGIC OBJECTS.
                static Class<VisitsHandler> VISITS_HANDLER = VisitsHandler.class;
                static VisitsHandler VISITS_HANDLER_IMPL = new VisitsHandlerImpl();
            }