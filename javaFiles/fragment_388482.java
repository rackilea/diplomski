GroovyCodeSource groovyCodeSource = new GroovyCodeSource(new File(scriptPath));

GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

Script script = InvokerHelper.createScript(groovyClassLoader.parseClass(groovyCodeSource), binding);
logger.info("getEndpointService().script : " + script);

Object responseObj = script.run();

logger.info("getEndpointService().responseObj : " + responseObj);