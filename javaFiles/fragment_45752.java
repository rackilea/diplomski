/**
 * Returns the file's content.
 */
public FileContent getContent() throws FileSystemException
{
    synchronized (fs)
    {
        attach();
        if (content == null)
        {
            content = new DefaultFileContent(this, getFileContentInfoFactory());
        }
        return content;
    }
}