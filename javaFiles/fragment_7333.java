public class Medicion {
private static final String TAG = "Medicion";

private String temperatura, presion, fecha, id;

public Medicion(String temperatura, String presion, String fecha, String id) {
    this.temperatura = temperatura;
    this.presion = presion;
    this.fecha = fecha;
    this.id = id;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Medicion medicion = (Medicion) o;

    return id.equals(medicion.id);
}

@Override
public int hashCode() {
    int result = id.hashCode();

    return result;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fecha) {
    this.fecha = fecha;
}

public String getPresion() {
    return presion;
}

public void setPresion(String presion) {
    this.presion = presion;
}

public String getTemperatura() {
    return temperatura;
}

public void setTemperatura(String temperatura) {
    this.temperatura = temperatura;
}