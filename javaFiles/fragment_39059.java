String fullFtpAddress = "ftp://user:password@ftp.domain.com:21";
String[] parts = fullFtpAddress.split("[:,@,/]");
String domain = parts[5];
String user = parts[3];
String password = parts[4];
String port = parts[6];