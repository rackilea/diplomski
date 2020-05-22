JSch jsch = new JSch();
Session session = null;
try {
  String command="grep 'keyword1' filename.txt|grep -v 'keyword2'";
  session = jsch.getSession(userid, servername, serverport);
  session.setPassword(password);
  session.setConfig("StrictHostKeyChecking", "no");
  session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
  session.connect();

  Channel channel = session.openChannel("exec");
  ((ChannelExec)channel).setCommand(command);
  channel.connect();

  InputStream commandOutput = channel.getInputStream();
  BufferedReader br = new BufferedReader(new      InputStreamReader(commandOutput));    
  String line="";                           
  while ((line = br.readLine()) != null)
 {
        System.out.println(line);                               
 }
  br.close();
  channel.disconnect();
  session.disconnect();
} catch (Exception e) {
  e.printStackTrace();
}