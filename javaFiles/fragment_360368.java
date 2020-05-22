import io.undertow.servlet.api.ServletContainerInitializerInfo;
import javax.servlet.ServletContainerInitializer;

public static Undertow buildUndertowServer(
        int port,
        String address,
        String contextPath,
        Class<? extends ServletContainerInitializer>
                servletContainerInitializerClass,
        Set<Class<?>> initializers,
        ClassLoader classLoader
) throws ServletException {

    ServletContainerInitializerInfo servletContainerInitializerInfo =
            new ServletContainerInitializerInfo(
                    servletContainerInitializerClass,
                    initializers);
    DeploymentInfo deployment = Servlets.deployment();
    deployment.addServletContainerInitializer(
            servletContainerInitializerInfo);
    deployment.setClassLoader(classLoader);
    deployment.setContextPath(contextPath);
    deployment.setDisplayName("adam");
    deployment.setDeploymentName("int-test");
    deployment.setServletStackTraces(ServletStackTraces.ALL);
    DeploymentManager manager =
            Servlets.newContainer().addDeployment(deployment);
    manager.deploy();
    Undertow.Builder builder = Undertow.builder();
    builder.addHttpListener(port, address);
    HttpHandler httpHandler = manager.start();
    httpHandler = Handlers.path().addPrefixPath(contextPath, httpHandler);
    builder.setHandler(httpHandler);
    return builder.build();
}