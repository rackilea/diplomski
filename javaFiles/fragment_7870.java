GetParameterRequest parameterRequest = new GetParameterRequest().withName("mailInfo").withWithDecryption(false);
AWSSimpleSystemsManagement ssmclient = AWSSimpleSystemsManagementClientBuilder.defaultClient();
GetParameterResult parameterResult = ssmclient.getParameter(parameterRequest);
String mailInfo = parameterResult.getParameter().getValue();

String[] params = mailInfo.split(",");
String stmp = params[0];
String username = params[1];
String password = params[2];
String defaultToMail = params[3];