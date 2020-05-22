SoapObject request = new SoapObject(NAMESPACE,METHOD);
SoapObject req_params = new SoapObject(NAMESPACE, "request");
req_params.addProperty("IsIPAD", "false");
req_params.addProperty("DeviceID", "test");
req_params.addProperty("DeviceType", "ipad");
req_params.addProperty("RequestKey", "UmVxdWVzdElzVmFsaWQxNjowNToyMDEyIDExOjU0%%");
req_params.addProperty("Period", "Month");
request.addSoapObject(req_params);

SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.dotNet=true;
envelope.implicitTypes = true;
envelope.setOutputSoapObject(request);