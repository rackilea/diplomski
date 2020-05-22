/* This evil reads a file as a resource inside a jar and dumps the file where ever
 * the loader of this jar/application defines as the current directory. This pain is done
 * so the SecurityDomian class can load the file; it cannot access the file from
 * the jar. This means the 'name' passed in contains the file name inside the jar
 * prefixed with "/" so it is not read with an assumed package extension.
 */
private boolean createFileFromResource(String name)
{
    // Dont bother if the file already exists
    if(new File(name.replace("/", "")).exists())
    { 
        return true;
    }
    byte[] keystoreFile = new byte[2048];
    ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(2048);
    // Get the resource
    InputStream inputStream = this.getClass().getResourceAsStream(name);
    try
    {
        int bytesRead = 0;
        while(true)
        {
            // Read the resource into the buffer keystoreFile in 2048 byte chunks
            bytesRead = inputStream.read(keystoreFile);
            if(bytesRead < 0)
            {
                break;
            }
            // Copy and append the chunks to the ByteArrayOutputStream (this class
            // does the auto-extending of the output array as more chunks are 
            // added so you don't have to do it.
            byteArrayOut.write(keystoreFile, 0, bytesRead);
        }
        inputStream.close();
        // Now create a file at the root of where ever the loader happens to think
        // the root is. So remove the "/" in front of the file name
        FileOutputStream outputStream = new FileOutputStream(name.replace("/", ""));
        // Write out the file. Note you will be left with garbage at that location.
        byteArrayOut.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    } 
    catch (IOException e)
    {
        e.printStackTrace();
        return false;
    }
    return true;
}