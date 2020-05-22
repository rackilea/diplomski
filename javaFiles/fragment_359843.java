public interface RingElem< T extends RingElem< T > > {

    public abstract RingElem< T > add( RingElem< T > e );

    public abstract RingElem< T > multiply( RingElem< T > e );
}