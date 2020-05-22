Properties props = new Properties();
props.load(new FileInputStream("myfile.properties"));
for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements(); ) {
    String name = (String)e.nextElement();
    String value = props.getProperty(name);
    // now you have name and value
    if (name.startsWith("Appname")) {
        // this is the app name. Write yor code here
    }
}