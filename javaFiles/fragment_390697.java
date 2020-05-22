public class MyServer extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put("jersey.config.server.disableMoxyJson", true);
        return map;
    }

}