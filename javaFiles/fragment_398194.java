serviceClient = new RPCServiceClient();
Options options = serviceClient.getOptions();

EndpointReference targetEPR = new EndpointReference("http://myservice");

options.setTo(targetEPR);

QName methodName = new QName("ns","methodName");

Class<?>[] returnTypes = new Class[] { String.class };

Object[] args = new Object[] { "parameter" };

Object[] response = serviceClient.invokeBlocking(methodName, args,
                returnTypes);