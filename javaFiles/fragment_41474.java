public Object clone() {
    try {
        Nod clone = (Nod)super.clone();
        clone.stare = (int[][])stare.clone();
        return clone;
    } catch (CloneNotSupportedException cnse) {
       //won't happen;
       throw new RuntimeError("Won't happen");
    }
}