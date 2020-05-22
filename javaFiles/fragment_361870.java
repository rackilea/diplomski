@Override public boolean equals(Object o) {
    if(o == this) return true;
    if(!(o instanceof MyDateClass)) return false;
    MyDateClass that = (MyDateClass) o;

    // use == for primitives
    // use .compare for primitive wrappers where available
    // use .equals for objects 
    return this.ivar1 == that.ivar2 &&
           this.ivar2 == that.ivar2; //etc...    
}

// equal objects must have equal hash codes
@Override public int hashCode() {
    int result = 17;
    result = 31 * result + ivar1;
    result = 31 * result + ivar2;
    return result;
}