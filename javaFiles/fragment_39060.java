URI uri = URI.create(fullFtpAddress);
String domain = uri.getHost();
String userInfo = uri.getUserInfo();
String user = userInfo != null ? userInfo.split(":")[0] : null;    
String password = userInfo != null ? userInfo.split(":")[1]: null;
int port = uri.getPort();