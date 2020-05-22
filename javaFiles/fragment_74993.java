public boolean equals(Object o) {
    if (o instanceof Pair){
         Pair p = (Pair)o;
         return (this.getLeft().equals(p.getLeft()) && this.getRight() == p.getRight());
    }
    return false;
}