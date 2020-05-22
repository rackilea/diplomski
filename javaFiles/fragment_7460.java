boolean zZ = true;
int aA = 1001, bB = 1002;
int xX, yY;                           // <--- declaration is outside WHILE
while (zZ) {
    xX = aA;
    yY = bB;
    zZ = (xX == yY);
}