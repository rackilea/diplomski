public T cast(Object arg0) {
    if (arg0 != null && !this.isInstance(arg0)) {
        throw new ClassCastException(this.cannotCastMsg(arg0));
    } else {
        return arg0;
    }
}