Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
long offset = 0;
while (zipEntries.hasMoreElements())
{
    ZipEntry entry = (ZipEntry)zipEntries.nextElement();
    long fileSize = 0;
    long extra = entry.getExtra() == null ? 0 : entry.getExtra().length;
    offset += 30 + entry.getName().length() + extra;
    if(!entry.isDirectory())
    {
        fileSize = entry.getCompressedSize();

        // Do stuff here with fileSize & offset
    }    
    offset += fileSize;
}