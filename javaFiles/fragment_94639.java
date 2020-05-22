//usage
Employee valid(Employee x, Employee y) {
    return v(x,y);
}

//generic method for validation
<T> T v(T o1, T o2) {
    return o1==null?o2:o1;
}