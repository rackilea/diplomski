final String propertySourceName = "externalConfiguration"; 
// name of propertySource as defined by 
// @PropertySource(name = "externalConfiguration", value = "${application.config.location}")
ResourcePropertySource propertySource = new ResourcePropertySource(propertySourceName, new FileSystemResource(file));
MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
sources.replace(propertySourceName, propertySource);