boolean zZ = true;
int aA = 1001, bB = 1002;
while (zZ) {
    int xX = aA;                      // <--- declaration is inside WHILE
    int yY = bB;
    zZ = (xX == yY);
}