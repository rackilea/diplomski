@Bean
public VaadinServlet vaadinServlet(){
    return new SpringVaadinServlet(){
        @Override
        protected VaadinServletService createServletService(DeploymentConfiguration deploymentConfiguration) throws ServiceException {
            SpringVaadinServletService servletService = new SpringVaadinServletService(this, deploymentConfiguration, getServiceUrlPath()) {
                // Override any custom method here
            }
        }
    };
}