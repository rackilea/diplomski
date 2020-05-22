public boolean isTheSame(Collection<? extends Compress> a, Collection<? extends Compress> b) {
        Equator<Compress> compressEquator = new CompressEquator();
        return CollectionUtils.isEqualCollection(a, b, compressEquator); 
 }

    public static class CompressEquator implements Equator<Compress> {

    public boolean equate(Compress c1, Compress c2) {
       return c1.isTheSame(c2);
    }
    //
  }
}