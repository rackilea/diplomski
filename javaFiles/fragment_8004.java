public int increment(int increment) throws MPIException {

    // A list to store all of the values we pull
    ArrayList<Integer> vals = new ArrayList<Integer>();
    for (int i = 0; i < this.getSize(); i++)
        vals.add(i, 0);

    // Need to convert the increment to a buffer
    ByteBuffer incrbuff = ByteBuffer.allocateDirect(Integer.BYTES);
    incrbuff.putInt(increment);

    // Our values are returned to us in several byte buffers
    ByteBuffer valBuff[] = new ByteBuffer[this.getSize()];

    this.getWin().lock(MPI.LOCK_EXCLUSIVE, this.getHostRank(), 0);
    for (int i = 0; i < this.getSize(); i++) {
        // Always ensure that we're at the top of the buffer
        if (i == this.getRank()) {
            this.getWin().accumulate(incrbuff, 1, MPI.INT, this.getHostRank(), i, 1, MPI.INT, MPI.SUM);
        } else {
            valBuff[i] = ByteBuffer.allocateDirect(Integer.BYTES);
            valBuff[i].position(0);
            this.getWin().get(valBuff[i], 1, MPI.INT, this.getHostRank(), i, 1, MPI.INT);
        }
    }
    this.getWin().unlock(this.getHostRank());
    for (int i = 0; i < this.getSize(); i++) {
        if (i != this.getRank()) {
            vals.set(i, valBuff[i].getInt(0));
        }
    }

    this.setMyVal(this.getMyVal() + increment);
    vals.set(this.getRank(), this.getMyVal());

    return vals.stream().mapToInt(Integer::intValue).sum();

}