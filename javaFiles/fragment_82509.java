/**
 * Two Path Cycle Strategy
 * 
 * @author wf
 * 
 */
public static class TwoPathCycleStrategy extends CycleStrategy {
    String id;
    String ref;
    public static boolean debug = false;

    /**
     * create a twoPath Cycle Strategy
     * 
     * @param id
     * @param ref
     */
    public TwoPathCycleStrategy(String id, String ref) {
        super(id, ref);
        this.id = id;
        this.ref = ref;
    }

    /**
     * show debug information
     * 
     * @param title
     * @param key
     * @param value
     */
    public void showDebug(String title, String key, Value value) {
        if (debug) {
            String id = "?";
            Object v = value;
            while ((v instanceof Value) && ((Value) v).isReference()) {
                v = ((Value) v).getValue();
            }
            if (v == null) {
                id = "null";
            } else {
                // FIXME - adapt to your code or comment out
                //if (v instanceof ModelElement) {
                //  ModelElement me = (ModelElement) v;
                //  id = me.getId();
                //}
            }
            System.err.println(title + ":" + key + "->"
                    + v.getClass().getSimpleName() + ":"
                    + value.getType().getSimpleName() + ":" + value.isReference() + ":"
                    + id);
        }
    }

    public Map<String, Value> lookup = new HashMap<String, Value>();

    @SuppressWarnings("rawtypes")
    @Override
    public Value read(Type type, NodeMap node, Map map) throws Exception {
        Value value = null;
        Node refNode = node.get(ref);
        Node keyNode = node.get(id);
        try {
            value = super.read(type, node, map);
            if (keyNode != null) {
                String key = keyNode.getValue();
                if (value != null) {
                    showDebug("id", key, value);
                    lookup.put(key, value);
                } else {
                    showDebug("id?", key, value);
                }
            }
        } catch (CycleException ce) {
            if (ce.getMessage().contains("Invalid reference")) {
                if (refNode != null) {
                    String key = refNode.getValue();
                    if (lookup.containsKey(key)) {
                        value = lookup.get(key);
                        showDebug("ref", key, value);
                    } else {
                        showDebug("ref?",key,null);
                    }
                }
            } else {
                throw ce;
            }
        }
        return value;
    }

}