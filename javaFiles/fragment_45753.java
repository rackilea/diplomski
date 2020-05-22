protected long doGetLastModifiedTime() throws Exception
{
    if (attrs == null
            || (attrs.getFlags() & SftpATTRS.SSH_FILEXFER_ATTR_ACMODTIME) == 0)
    {
        throw new FileSystemException(
                "vfs.provider.sftp/unknown-modtime.error");
    }
    return attrs.getMTime() * 1000L;
}