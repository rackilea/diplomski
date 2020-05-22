public class Config {

    public static String DB_ACCESS_URL;

    @Value(value = "${myapp.database-access.url}")
    public void setDbAccessUrl(String dbAccessUrl) {
        Config.DB_ACCESS_URL = dbAccessUrl;
    } 
}