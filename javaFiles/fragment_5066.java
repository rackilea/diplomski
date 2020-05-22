public class NodoJugadores implements Serializable {

    private String nombre ;

    private final PropertyChangeSupport pcs ;

    public NodoJugadores() {
        this.pcs = new PropertyChangeSupport(this);
    }

    public String getNombre() {
        return nombre ;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre ;
        this.nombre = nombre ;
        pcs.firePropertyChange("nombre", oldNombre, this.nombre);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

}