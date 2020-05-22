class IDAllocator {
    Storage storage;
    int     nextId;
    int     idCount;
    int     blockSize;
    long    lastIdTime;

    /**
     * Creates an IDAllocator with the given server ID, backing storage,
     * and block size.
     *
     * @param   serverId        the ID of the server (e.g., 12)
     * @param   s               the backing storage to use
     * @param   size            the block size to use
     * @throws  SomeException   if something goes wrong
     */
    IDAllocator(int serverId, Storage s, int size)
    throws SomeException {

        // Remember our info
        this.serverId = serverId * 1000000; // Add a million to make life easy
        this.storage = s;
        this.nextId = 0;
        this.idCount = 0;
        this.blockSize = bs;
        this.lastIdTime = this.getDayMilliseconds();

        // Get the first block. If you like and depending on
        // what container this code is running in, you could
        // spin this out to a separate thread.
        this.getBlock();
    }

    public synchronized int getNextId()
    throws SomeException {
        int id;

        // If we're out of IDs, or if the day has changed, get a new block
        if (idCount == 0 || this.lastIdTime < this.getDayMilliseconds()) {
            this.getBlock();
        }

        // Alloc from the block    
        id = this.nextId;
        --this.idCount;
        ++this.nextId;

        // If you wanted (and depending on what container this
        // code is running in), you could proactively retrieve
        // the next block here if you were getting low...

        // Return the ID
        return id + this.serverId;
    }

    protected long getDayMilliseconds() {
        return System.currentTimeMillis() % 86400000;
    }

    protected void getBlock()
    throws SomeException {
        int id;

        synchronized (this) {
            synchronized (this.storage.syncRoot()) {
                id = this.storage.readIntFromStorage();
                this.storage.writeIntToStroage(id + blocksize);
            }

            this.nextId = id;
            this.idCount = blocksize;
        }
    }
}