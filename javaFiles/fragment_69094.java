public boolean equals(Object object){
    boolean same = false;

    if (object != null && object instanceof Correction)
    {
        same = this.node0.equals(((Correction) object).node0) && this.node1.equals(((Correction) object).node1);
    }

    return same;
}