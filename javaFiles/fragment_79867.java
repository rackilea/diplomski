DeploymentManager deploymentManager = new DeploymentManager();
deploymentManager.setContexts(contextHandlerCollection);
deploymentManager.setContextAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
        ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/org.apache.taglibs.taglibs-standard-impl-.*\\.jar$");

deploymentManager.addLifeCycleBinding(new StandardStarter());
deploymentManager.addLifeCycleBinding(new StandardStopperCustom());
deploymentManager.addLifeCycleBinding(new StandardDeployer());
deploymentManager.addLifeCycleBinding(new StandardUndeployer());
deploymentManager.setUseStandardBindings(false);

deploymentManager.addAppProvider(webAppProvider);