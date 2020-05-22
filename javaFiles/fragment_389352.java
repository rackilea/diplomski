byte x = -1;
int x2 = ((int)x) & 0xff;
int x3;
int x4 = x2;
for(int i = 0; i < 8; i++)
{
    x2 = (x2 >>> 1);
    System.out.println("X2: " + x2);
    x3 = (x >>> 1);
    x = (byte)x3;
    x4 = (x4 >>> 1);
    System.out.println("X: " + x3 + " " + x + " " + x4);
}