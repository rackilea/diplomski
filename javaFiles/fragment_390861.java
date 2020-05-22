File confDir = new File(System.getProperty("catalina.base"), "conf");
File confFile = new File(confDir, "myprops.properties");
InputStream in = new FileInputStream(confFile);
try {
    props.load(in);
} finally {
    in.close();
}