static void dog(int i, int b, int c, int array[]) {

    if (c<array.length-1 && array[i] <= array[c] ) {
        if (c <(int) array.length-1) {
            int y = array[i];
            array[i] = array[b];
            array[b] = y;
            if (b < array.length)
                return;
            else
                b++;
            i = b;
            c = b;
            dog(i, b, c, array);
        } else
            c++;
        dog(i, b, c, array);
    } else
        i++;
    c = b;
    dog(i, b, c, array);
}