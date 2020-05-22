@Override public int hashCode() {
    return Arrays.hashCode(new Object[] {
           myInt,    //auto-boxed
           myDouble, //auto-boxed
           myRandomClass,
    });
}