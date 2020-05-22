final JSch jsch = new JSch();
    final Session sessionJSH = jsch.getSession(user, host, 22);
    sessionJSH.setPassword(pwd);
    final Hashtable configJSH = new Hashtable();
    configJSH.put("StrictHostKeyChecking", "no");
    sessionJSH.setConfig(configJSH);
    sessionJSH.connect();
    final Channel channel = sessionJSH.openChannel("exec");
    ((ChannelExec) channel).setCommand(command);
    channel.connect(0);
    // we'll hold it until 30 minutes = 30m*60s*1000ms/300ms = 6000 times
    int i = 0;
    while (channel.getExitStatus() == -1 && i < 6000) {
        log.debug("Exit status" + channel.getExitStatus());
        Thread.sleep(300);
        i++;
    }
    log.info("Exit status" + channel.getExitStatus());
    channel.disconnect();
    sessionJSH.disconnect();