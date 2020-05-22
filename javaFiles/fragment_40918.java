public static void main(String[] args)
{
    int[] array = {1, 3, 5, 6, 8, 12, 19, 21, 27, 31, 35, 45, 80, 81, 82, 85, 87, 89, 95, 101, 200, 501, 707, 1000};
    Scanner teclado = new Scanner(System.in);
    System.out.print("Enter number of runs: ");
    int n = teclado.nextInt();
    int esquerda = 0;
    int direita = array.length-1;
    for(int i = 0; i < n; i++) {
        System.out.print("Enter number to search for: ");
        int x = teclado.nextInt();
        System.out.println(buscaBinaria(array, esquerda, direita, x));
    }
}