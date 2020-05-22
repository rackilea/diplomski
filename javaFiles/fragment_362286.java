Scanner teclado = new Scanner(System.in);
System.out.println("Ingresa el numero N");
int n = teclado.nextInt();

for (int i=1; i <= n; ++i) {
    if (i > 1) System.out.print(",");
    System.out.print(i + "," + (-i));
}