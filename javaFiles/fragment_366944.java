int add(int x, int y) {
int a, b;
do {
    a = x & y;           
    b = x ^ y; 
    x = a << 1; 
    y = b;
} while (a != 0);
return b;
}