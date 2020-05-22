public int compareTo(java.util.Date o) {
    if(o instanceof Timestamp) {
    // When Timestamp instance compare it with a Timestamp
    // Hence it is basically calling this.compareTo((Timestamp))o);
    // Note typecasting is safe because o is instance of Timestamp
    return compareTo((Timestamp)o);
    } else {
    // When Date doing a o.compareTo(this)
    // will give wrong results.
    Timestamp ts = new Timestamp(o.getTime());
    return this.compareTo(ts);
    }
}