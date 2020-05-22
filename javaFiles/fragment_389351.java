byte x = -1;
int x2 = ((int)x) & 0xff;
for(int i = 0; i < 8; i++)
{
    x2 = (x2 >>> 1);
    System.out.println("X: " + x2);
}