public class PolylinjeIterator { 
    private int aktuell = -1; 
    private final Polylinje polylinje;

    public PolylinjeIterator (Polylinje polylinje){ 
        this.polylinje = polylinje;
        if (polylinje.getHorn().length > 0) 
            aktuell = 0; 
    }