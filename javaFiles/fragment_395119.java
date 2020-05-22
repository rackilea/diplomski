EndpointDescription[] endpoints = myClient.discoverEndpoints(url);
// Filter out all but opc.tcp protocol endpoints
endpoints = selectByProtocol(endpoints, "opc.tcp");
// Filter out all but Signed & Encrypted endpoints
endpoints = selectByMessageSecurityMode(endpoints, MessageSecurityMode.None);

// Choose one endpoint
if (endpoints.length == 0)
  throw new Exception("The server does not support insecure connections");
EndpointDescription endpoint = endpoints[0];
//////////////////////////////////////
SessionChannel mySession = myClient.createSessionChannel(endpoint);