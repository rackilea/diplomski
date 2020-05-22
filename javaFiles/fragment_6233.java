IClient client = new ClientBuilder("https://10.0.75.2:8443")
                    .withUserName("developer")
                    .withPassword("developer")
                    .build();
IProject project = client.getResourceFactory().stub(ResourceKind.PROJECT, "prj4testing");
IDeploymentConfig deploymentConfig = client.getResourceFactory().stub(ResourceKind.DEPLOYMENT_CONFIG, "postgresql", project.getName());
IDeploymentTriggerable capability = deploymentConfig.getCapability(IDeploymentTriggerable.class);
capability.setForce(true);
capability.setLatest(true);
capability.trigger();