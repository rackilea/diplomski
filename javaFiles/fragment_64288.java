public final class ArrayFieldVectorUtils {

    private ArrayFieldVectorUtils(){
        // avoid instantiation
    }

    public static ArrayFieldVector<Complex> pow(final ArrayFieldVector<Complex> a, int pow){
       Complex[] out = new Complex[a.length];
       for(int i=0;i<a.length;i++){
           out[i]=a[i].pow(pow);
                                     }
       return new ArrayFieldVector<Complex>(out);
    }
}