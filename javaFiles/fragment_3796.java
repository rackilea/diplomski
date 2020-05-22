public void reverse(Object [] a){
    for(int i = 0; i < a.length / 2; i++){
        Object temp = a[i]; // swap using temporary storage
        a[i] = a[a.length - i - 1];
        a[a.length - i - 1] = temp;
    }
}