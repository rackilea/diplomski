ArrayList<ChannelExec> channels = new ArrayList<ChannelExec>();

ChannelExec channel;
channel = (ChannelExec)session1.openChannel("exec");
channel.setCommand(
    "echo one && sleep 2 && echo two && sleep 2 && echo three");
channel.connect();
channels.add(channel);

channel = (ChannelExec)session2.openChannel("exec");
channel.setCommand(
    "sleep 1 && echo eins && sleep 2 && echo zwei && sleep 2 && echo drei");
channel.connect();
channels.add(channel);

ArrayList<InputStream> outputs = new ArrayList<InputStream>();
for (int i = 0; i < channels.size(); i++)
{
    outputs.add(channels.get(i).getInputStream());
}

Boolean anyOpened = true;
while (anyOpened)
{
    anyOpened = false;
    for (int i = 0; i < channels.size(); i++)
    {
        channel = channels.get(i);
        if (!channel.isClosed())
        {
            anyOpened = true;
            InputStream output = outputs.get(i);
            while (output.available() > 0)
            {
                int readByte = output.read();
                System.out.print((char)readByte);
            }
        }
    }
}