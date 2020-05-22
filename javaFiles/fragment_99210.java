public class Conf {

    public static class Key {

        final String key; 
        final Class<?> type;

        public Key (String key, Class<?> type) {
            this.key = key;
            this.type = type;
        }

    }

    public Object getValue (Key key) {
        ...
    }

}