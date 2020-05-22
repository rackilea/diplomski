String bin = "100100101011111011101011";
char[] cA = bin.toCharArray();
int ckA = 0, ckB = 0;
for (int i = 0; i < cA.length; i++){
    ckA = (ckA + Integer.valueOf(cA[i])/49) % 255;
    ckB = (ckB + ckA) % 255;
}
System.out.println(ckA);
System.out.println(ckB);

System.out.println((ckB << 8) | ckA);