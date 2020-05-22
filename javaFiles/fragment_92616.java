private static Map<Object, Object> info = new ConcurrentHashMap<>();

public static Connection getConnection(String key, boolean useConnectionPool, 
    String poolName) {

    ...
    Properties properties = new Properties();
    properties.putAll(info);
    connection = DriverManager.getConnection(connectionPoolUrl, properties);