if (min !=i) {
    int temp = a[i];
    a[i] = a[min];
    a[min]= temp;
    min = i;       /* Update `min' to reflect the number's new position */
}