private Expect4j SSH(String hostname, String username,String password, int port) throws Exception {
    JSch jsch = new JSch();
    Session session = jsch.getSession(username, hostname, port);
    if (password != null) {         
        session.setPassword(password);
    }
    Hashtable<String,String> config = new Hashtable<String,String>();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);
    session.connect(60000);
    channel = (ChannelShell) session.openChannel("shell");
    Expect4j expect = new Expect4j(channel.getInputStream(), channel.getOutputStream());
    channel.connect();      
    return expect;
}