GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

Script script = InvokerHelper.createScript(groovyClassLoader.parseClass(new
        File(scriptPath)), binding);
logger.info("getEndpointService().script : " + script);

Object responseObj = script.run();

logger.info("getEndpointService().responseObj : " + responseObj);