int n = 65
int d = 0;
while (n > 0) {
    if ((n & 1) == 1) {  // check LSB
        System.out.println(d);
    }
    n >>>= 1;  // shift right
    ++d;       // inc digit count
}