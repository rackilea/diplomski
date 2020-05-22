(...)
           org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[11]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("http://tempuri.org/foo/bar");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "bar"));

    setRequestHeaders(_call);
    setAttachments(_call);