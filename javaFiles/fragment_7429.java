String v = System.getProperty("java.version");
String[] version = v.split("\\.");
if (version==null)
{
    Log.info("Unable to determine jvm version, annotations will not be supported");
    return;
}
int  major = Integer.parseInt(version[0]);
int minor = Integer.parseInt(version[1]);