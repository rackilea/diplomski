public class SerializableLayeredPanne extends LayeredPanne implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 
     * the model you are able to FULLY restore layered pane and all its children from,
     * it MUST be serializable 
     */
    private final Serializable model;

    SerializableLayeredPanne(Serializable model) {
        this.model  = model;
    }

    public void init() {
        // set font, color etc.
        // add children
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        init();
    }

}