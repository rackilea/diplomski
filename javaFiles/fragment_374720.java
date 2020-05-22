Manifest manifest = new Manifest();
Attributes attr = manifest.getMainAttributes(); 
attr.put(Attributes.Name.MANIFEST_VERSION, "1.0");
// More attributes

FileOutputStream manifestFile = null;
try
{
    manifestFile = new FileOutputStream(filepath);
    manifest.write(manifestFile);
    manifestFile.close();
}
catch (IOException e)
{
    log.print(e);
}