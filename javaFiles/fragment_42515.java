protected void sshTesting(){
    String name = "";
    String userName = "kalenpw";
    String password = "hunter2";
    String ip = "192.168.0.4";
    int port = 22;
    String command = "cmus-remote -u";

    try{
        JSch jsch = new JSch();
        Session session = jsch.getSession(userName, ip, port);
        session.setPassword(password);

        //Missing code
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        //


        System.out.println("Establishing connection");
        session.connect(10);

        Channel channel = session.openChannel("exec");
        ((ChannelExec)channel).setCommand(command);
        channel.setInputStream(null);
        channel.connect(10000);

//            name = session.getUserName();
//            System.out.println(session.getHost());

    }
    catch(Exception e){
        System.err.print(e);
        System.out.print(e);
    }        

}