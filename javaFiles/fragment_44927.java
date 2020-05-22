int n = 48;
for (int i = 1; i < 26; i++)
    n = (n * 48) % 2401;
System.out.println(n);

int n2 = 48 * 48;
for (int i = 1; i < 13; i++)
    n2 = (n2 * 48 * 48) % 2401;
System.out.println(n2);

System.out.println(BigInteger.valueOf(48).pow(26).mod(BigInteger.valueOf(2401)));