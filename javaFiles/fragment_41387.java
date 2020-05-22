package java.lang;
...
import java.util.Properties;
...
private static Properties props;
....
public static String setProperty(String key, String value) {
checkKey(key);
SecurityManager sm = getSecurityManager();
    if (sm != null) {
    sm.checkPermission(new PropertyPermission(key,
    SecurityConstants.PROPERTY_WRITE_ACTION));
}

return (String) props.setProperty(key, value); //line 729
}