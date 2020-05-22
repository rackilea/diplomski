public void fileWriter() throws FileNotFoundException {
    File file = new File("C:\\Users\\john\\Desktop\\stats.txt");
    try (PrintWriter print = new PrintWriter(file)) {
        print.print(Integer.toString(swordNumber) + " ");
        print.print(Integer.toString(shieldNumber) + " ");
        print.print(Integer.toString(monstersDefeated) + " ");
        print.print(Integer.toString(damageDealt));
    }
}