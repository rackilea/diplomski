public class ChainedResourceBundle extends ResourceBundle implements Enumeration<String> {

    Iterator<Map.Entry<Module, ResourceBundle>> tables;
    private Enumeration<String>                 keys;

    private Map<Module, ResourceBundle>         internalMap    = new HashMap<Module, ResourceBundle>();
    private Map<String, String>                 customizedKeys = new HashMap<String, String>();


    @Override
    public Enumeration<String> getKeys() {
        tables = internalMap.entrySet().iterator();
        nextTable();
        return this;
    }


    @Override
    public boolean hasMoreElements() {
        return keys != null;
    }


    @Override
    public String nextElement() {
        String key = keys.nextElement();
        if (!keys.hasMoreElements()) {
            nextTable();
        }
        return key;
    }

    private void nextTable() {
        if (tables.hasNext()) {
            keys = tables.next().getValue().getKeys();
        } else {
            keys = null;
        }
    }

}