int a = 869;
int b = 85;
for(int i = 0; i < a; i++){
    System.out.printf(
            "Iteration %d: b = %d; b+b = %d; bin(b) = %s; bin(b+b) = %s%n",
            i, b, (b+b), Integer.toBinaryString(b), Integer.toBinaryString(b+b));
            b += b;
}
System.out.println(b);