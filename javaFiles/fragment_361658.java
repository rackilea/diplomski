public static void main(String[] args) {

    File file = new File("random_text_file.txt");

    try {

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String word = scanner.next();
            System.out.println(word);
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}