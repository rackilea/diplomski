public class Edge implements Parcelable {

    private Vertex from;
    private Vertex target;
    private double weigth;

    static HashMap<Long, Vertex> _parentsFrom = new HashMap<Long, Vertex>();
    static HashMap<Long, Vertex> _parentsTarget = new HashMap<Long, Vertex>();

    public long get_PKhash() { /* Return a unique identifier of your Edge object here */ }

    private ItemClass( Parcel in ) {
        (...)
        assertTrue( (from = _parentsFrom.remove( get_PKhash() )) != null );
        assertTrue( (target = _parentsTarget.remove( get_PKhash() )) != null );
    }

    public void writeToParcel( Parcel p, int args ) {
        (...)//Don't write to the parcel your from and target objects
        _parentsFrom.put( this.get_PKhash, from);
        _parentsTarget.put( this.get_PKhash, to);
    }
}