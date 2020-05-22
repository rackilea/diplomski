package nl.owlstead.stackoverflow;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ListenerToConfiguredVariable {

    // this could also be some kind of SeekBar or it could simply call it
    private final Handler handlerSeekBar = new Handler() {

        @Override
        public void handleValue(String value) {
            System.out.println("SeekBar : " + value);
        }

    };

    // this could also be some kind of EditText or it could simply call it
    private final Handler handlerEditText = new Handler() {

        @Override
        public void handleValue(String value) {
            System.out.println("EditText : " + value);
        }

    };

    private Map<String, Handler> map;

    {
//        createMapManually();
        createMapUsingReflection();
    }

    private void createMapManually() {
        Map<String, Handler> theMap = new HashMap<>();
        theMap.put("handlerSeekBar", handlerSeekBar);
        theMap.put("handlerEditText", handlerEditText);
        map = java.util.Collections.unmodifiableMap(theMap);
    }

    private void createMapUsingReflection() {
        Map<String, Handler> theMap = new HashMap<>();

        // iterate over all fields
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            // we only want the handlers, not any other field
            if (field.getType().isAssignableFrom(Handler.class)) {
                try {
                    theMap.put(field.getName(), (Handler) field.get(this));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        map = java.util.Collections.unmodifiableMap(theMap);
    }

    interface Handler {
        void handleValue(String value);
    }

    public static class Config {
        public String getConfiguredVariable() {
            return "handlerSeekBar";
        }
    }

    public ListenerToConfiguredVariable() {
        Config config = new Config();
        // the for loop simulates reading all the values from the XML file
        for (int i = 0; i < 10; i++) {
            // this would be inside the listener
            String var = config.getConfiguredVariable();
            Handler handler = map.get(var);
            handler.handleValue(Integer.toString(i));
        }
    }

    public static void main(String[] args) {
        new ListenerToConfiguredVariable();
    }
}