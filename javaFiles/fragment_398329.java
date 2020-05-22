Map<String,Object> props = new HashMap<String, Object>();
props.put("mtom-enabled", Boolean.TRUE);
JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

factory.setServiceClass(UploadSEI.class);
factory.setAddress("http://localhost:8080/CxfService/UploadWS");
factory.setProperties(props); 

UploadSEI client = (UploadSEI) factory.create();