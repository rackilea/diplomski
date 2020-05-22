private List<String> runNexusCommandViaSSH(String sshuser, String sshpass, String sshhost, String command) throws JSchException, IOException {
    List<String> results = new ArrayList<String>();

    java.util.Properties config = new java.util.Properties();
    config.put("StrictHostKeyChecking", "no");

    JSch jsch = new JSch();

    Session session = jsch.getSession(sshuser, sshhost, 22);

    session.setPassword(sshpass);
    session.setConfig(config);
    session.setTimeout(10000);
    session.connect();

    Channel channel = session.openChannel("shell");

    channel.setInputStream(null);
    channel.setOutputStream(null);

    InputStream in = channel.getInputStream();
    OutputStream out = channel.getOutputStream();

    ((ChannelShell)channel).setPtyType("vt102");
    channel.connect();

    byte[] tmp=new byte[1024];

    out.write((command + ";exit").getBytes());
    out.write(("\n").getBytes());
    out.flush();

    while (true) {  

        while (in.available() > 0) {
            int i = in.read(tmp, 0, 1024);
            if (i < 0) {
                //System.out.println("[debug] breaking at i < 0");
                break;
            }
            String buffer = new String(tmp, 0, i);
            results.add(buffer);
            //System.out.println("[debug]" + buffer);
            if(buffer.contains("REMOTE JSH COMMAND FINISHED")){
                System.out.println("[debug] breaking at finished");
                break;
            }
        }
        if (channel.isClosed()) {
            //System.out.println("[debug] breaking at isClosed");
            in.close();
            break;
        }
    }
    channel.disconnect();
    session.disconnect();

    return results;
}