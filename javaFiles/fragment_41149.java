public class Elemento implements Comparable<Elemento> {
    public int Dato;
    public int Siguiente;

    public Elemento(int dato, int siguiente) {
         this.Dato = dato;
         this.Siguiente = siguiente;
    }
    @Override
    public int compareTo(Elemento compare) {
        return this.Siguiente - compare.Siguiente;
    }   
}