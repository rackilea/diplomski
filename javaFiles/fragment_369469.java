public static void main(String[] args) throws FileNotFoundException {
    File f = new File("text.txt");
    Scanner scanner = new Scanner(f);
    int counter = 1; //This will tell you which line you are on

    while(scanner.hasNextLine()) {
        if (counter % 2 == 0) { //This checks if the line number is even
            System.out.println(scanner.nextLine());
        }
        counter++; //This says we just looked at one more line
    }
}