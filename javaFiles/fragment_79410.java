Channel channel = session.openChannel("exec");
((ChannelExec) channel).setCommand("java -cp /.../weblogic.jar weblogic.WLST");
OutputStream out = channel.getOutputStream();
channel.connect();
out.write(("connect('weblogic'...)\n").getBytes());
out.write(("domainRuntime()\n").getBytes());
...