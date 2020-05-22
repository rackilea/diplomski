FTPClient client = = new FTPClient();
InputStream is = null;
client.connect(AppValues.ftpurl);
client.login(AppValues.ftpname, AppValues.ftppass);
client.setFileType(FTP.BINARY_FILE_TYPE); 
client.enterLocalPassiveMode();
is = new FileInputStream("C:\\Users\\path\\filename");
boolean stored = client.storeFile(fileName, is);
System.out.println("Stored? " + stored);