ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
channelExec.setCommand("bash -s");
channelExec.connect();
OutputStream out = channel.getOutputStream();
FileInputStream fis = new FileInputStream("testScript.sh");
byte[] buf = new byte[1024];
while (true)
{
    int len = fis.read(buf, 0, buf.length);
    if (len <= 0) break;
    out.write(buf, 0, len);
}