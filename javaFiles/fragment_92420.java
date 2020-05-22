public static void binary(int n, char [] array, int bits) {

    if(0 == n) { 
        return ;
    }

    int temporal = n;
    n = n/2;

    if (temporal % 2 == 0) { 
        array[bits-1]='0';
    }

    else {
        array[bits-1]='1';
    }

    binary(n, array, bits-1);
}