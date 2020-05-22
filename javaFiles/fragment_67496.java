String user = "user:password";
NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
String path = "smb://my_machine_name/D/MyDev/test.txt";
SmbFile sFile = new SmbFile(path, auth);
SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
sfos.write("Test".getBytes());
sfos.close();