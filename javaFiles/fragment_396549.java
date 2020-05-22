SOAPPart soappart = message.getSOAPPart();
            SOAPEnvelope envelope = soappart.getEnvelope();
            SOAPHeader header = envelope.getHeader();
            WSSecHeader wsheader = new WSSecHeader();
            wsheader.insertSecurityHeader(soappart);
            WSSecUsernameToken token = new WSSecUsernameToken();
            token.setPasswordType(WSConstants.PASSWORD_DIGEST);
            token.setUserInfo("myuser", "mypass");
            token.build(soappart, wsheader);