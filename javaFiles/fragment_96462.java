B.Client bClient = <.....>

Endpoint endpoint = bClient.getA();
TTransport transport = new TSocket(endpoint.host, endpoint.port);
transport.open();
A.Client aClient = = new A.Client(new TBinaryProtocol(transport));
aClient.somefunc2();