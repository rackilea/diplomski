SSHClient ssh = new SSHClient();

ssh.loadKnownHosts();
ssh.connect("your-server");
ssh.authPublickey("userId");

//START SESSION
Session session = ssh.startSession();
//SEND THE COMMAND
Command cmd = session.exec("shutdown");
//GET THE OUTPUT OF COMMAND
cmd.getOutputAsString();
//CLOSE SESSION
session.close();
ssh.disconnect();