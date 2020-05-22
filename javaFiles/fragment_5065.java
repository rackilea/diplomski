public class NodoJugadores implements Serializable {

    private final transient StringProperty nombre = new SimpleStringProperty();

    public StringProperty nombreProperty() {
        return nombre ;
    }

    public final String getNombre() {
        return nombreProperty().get();
    }

    public final void setNombre(String nombre) {
        nombreProperty().set(nombre);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(getNombre());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.nombre = new SimpleStringProperty((String) s.readObject());
    }
}