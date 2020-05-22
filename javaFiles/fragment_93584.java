TeleCastStub stub = new TeleCastStub();

SoapAuthenticationHeader auth = new SoapAuthenticationHeader();
auth.setUsername(username);
auth.setPassword(password);

QueueRealTimeEmail pageObj = new QueueRealTimeEmail();
pageObj.setFrom(from);
pageObj.setTo(to);
pageObj.setSubject(subject);
pageObj.setBody(body);

SoapAuthenticationHeaderE authE = new SoapAuthenticationHeaderE();
authE.setSoapAuthenticationHeader(auth);

QueueRealTimeEmailResponse response = stub.queueRealTimeEmail(pageObj, authE);