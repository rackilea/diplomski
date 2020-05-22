class ConcurrMattr {

    private ConcurrentHashMap<Integer, Lock> locks = 
                    new ConcurrentHashMap<Integer, Lock>();

    public Cell put( CellCoords key, Cell arg1 ) {
        // get or create lock for specific cell (guarantee its uniqueness)
        Lock lock = this.locks.putIfAbsent( coords.hash % 64, new ReentrantLock() );
        // 64 threads may concurrently modify different cells of matrix

        try {
            // lock only specific cell
            lock.lock();

            // do all you need with cell

            return ...;

        } finally {
            // unlock cell
            lock.unlock();
        }
    }    
}


// Immutable class to represent cell coordinates
class CellCoords {    
    public final int x;
    public final int y;
    public final int hash;

    public CellCoords( int x, int y ) {
        this.x = x;
        this.y = y;
        this.hash = this.calcHash();
    }

    private int calcHash() {
        int result = 31 + this.x;
        return 31 * result + this.y;
    }
}