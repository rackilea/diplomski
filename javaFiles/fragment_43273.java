public class WidthComparator implements Comparator<Foto>{
    private final static Comparator<Foto> FOTO_COMPARATOR = Comparator.comparing(Foto::getWidth)
        .thenComparing(Foto::getHeight)
        .thenComparingInt(Foto::getName);

    @Override
    public int compare(Foto foto1, Foto foto2) {    
        return FOTO_COMPARATOR.compare(foto1, foto2);        
    }    
}