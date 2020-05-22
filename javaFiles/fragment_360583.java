public static void listDirectory(
    ChannelSftp channelSftp, String path, List<String> list) throws SftpException
{
    Vector<LsEntry> files = channelSftp.ls(path);
    for (LsEntry entry : files)
    {
        if (!entry.getAttrs().isDir())
        {
            list.add(path + "/" + entry.getFilename());
        }
        else
        {
            if (!entry.getFilename().equals(".") && !entry.getFilename().equals(".."))
            {
                listDirectory(channelSftp, path + "/" + entry.getFilename(), list);
            }
        }
    }
}