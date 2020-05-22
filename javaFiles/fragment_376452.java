// if the table is to be filled with colors, declare it an table of Color
public static void rellenarTablero(Color[][] tablero) {
    System.out.println("Introduzca el numero de colores (de 2 a 6): ");
    Scanner in = new Scanner(System.in);
    int colores = in.nextInt();
    while (colores < 2 || colores > 6) {
        System.out.println("Elija un numero valido:");
        colores = in.nextInt();
    }
    // I prefer to use a Random object for random integers, it’s a matter of taste
    Random rand = new Random();
    for (int x = 0; x < tablero.length; x++) {
        for (int y = 0; y < tablero[x].length; y++) {
            int numeroAleatorioDeColor = 1 + rand.nextInt(3);
            // prefer if-else to make sure exactly one case is chosen
            if (numeroAleatorioDeColor == 1) {
                // fill the color into the table (not the int)
                tablero[x][y] = Color.BLUE;
            }
            else if (numeroAleatorioDeColor == 2) {
                tablero[x][y] = Color.RED;
            }
            else if (numeroAleatorioDeColor == 3) {
                tablero[x][y] = Color.GREEN;
            }
            else {
                System.err.println("Error interno " + numeroAleatorioDeColor);
            }
        }
    }
}