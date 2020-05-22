public String callWS(String arg1 ,String arg2){
org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("web service URL");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        //pay attention to line below
        _call.setProperty(org.apache.axis.client.Call.CHECK_MUST_UNDERSTAND, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://zzzzz", "xxxx"));
        setRequestHeaders(_call);
        setAttachments(_call);

        Object _resp = _call.invoke(new Object[] {arg1,arg2});
        return (String) org.apache.axis.utils.JavaUtils.convert(_resp, String.class);

}