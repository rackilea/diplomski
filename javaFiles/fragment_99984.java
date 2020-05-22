public class PriceBuyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
             return new Class[]{HibernateConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            // TODO Auto-generated method stub
            return new Class[] {PriceBuyWebApplicationConfiguration.class, ConverterConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            // TODO Auto-generated method stub
            return new String[] {"/"};
        }


    }