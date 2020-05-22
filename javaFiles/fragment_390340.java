PulsarAdmin pulsarAdmin = PulsarAdmin.builder().serviceHttpUrl("http://localhost:8080").build();

FunctionConfig functionConfig = new FunctionConfig();
functionConfig.setName("exclamation");
functionConfig.setInputs(Collections.singleton("input"));
functionConfig.setClassName(ExclamationFunction.class.getName());
functionConfig.setRuntime(FunctionConfig.Runtime.JAVA);
functionConfig.setOutput("output");
functionConfig.setJar("/tmp/my-jar.jar")

pulsarAdmin.functions().createFunction(functionConfig, functionConfig.getJar());