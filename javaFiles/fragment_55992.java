public static void main(String[] args) {
    valorCompras(new Scanner(System.in));
}

static double valorCompras(Scanner sc){
    int compra = 4;
    double  dinheiro = 5000;
    double[] vcompras = new double[compra];
    double saldo = dinheiro;

    if (compra > 0)
        for( int u = 0 ; u < vcompras.length ; u++ ){
            vcompras[u] = sc.nextDouble();
            saldo -= vcompras[u];

        }
    System.out.println("ficou com "+saldo+" de saldo na conta");
    return saldo;   

}