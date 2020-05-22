public Class1D(int degree, int[] a){

    this.degree =degree;
    this.coefficient = a.clone();
    // You can also another way that is faster, use:
    // System.arraycopy(a, 0, this.coefficient, 0, a.length);

}