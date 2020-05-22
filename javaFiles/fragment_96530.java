String[] movieList = new String[4];
File file = new File("xxx\\listofmovies.txt");
Scanner fileScanner = new Scanner(file);
Scanner scanner = new Scanner(System.in);
Random random = new Random();

int index = 0;
while (fileScanner.hasNextLine()) {
    String line = fileScanner.nextLine();
    movieList[index] = line;
    index++;
}