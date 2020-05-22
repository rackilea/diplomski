boolean zZ = true;
int aA = 1001;
int bB = 1002;
while (zZ) {
    final int xX = aA;   // <------- took away the "final" here, didnt matter
    final int yY = bB;   // <------- took away the "final" here, didnt matter
    zZ = (xX == yY);
}