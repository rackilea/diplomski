private void doubleCapacity() {

    int p = floorMod((this.backIndex+1 ), capacity);
    int n = holder.length;
    int r = n - p; // number of elements to the right of p
    capacity = (n) * 2;
    Object[] a = new Object[capacity];
    System.arraycopy(holder, p, a, 0, r);
    System.arraycopy(holder, 0, a, r, p);
    holder = (Item[]) a;
    //backIndex should be the last element of the whole array
    this.backIndex = capacity-1;
    //frontIndex must be 1 after the last element of the portio of array populated by items  
    this.frontIndex = n;
}