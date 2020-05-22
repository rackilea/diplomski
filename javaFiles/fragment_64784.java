public static void main(String[] args) {
    String line="";

    try (PrintWriter writer = new PrintWriter(new File("D:\\hl_sv\\hello2.txt"));

    Scanner scanner = new Scanner(new File("D:\\hl_sv\\hello.txt"))) {

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            // In the case the line is the last one and there is no number.
            // The content of the arrayList must be printed.

        }

        System.out.println("last line in the text document");
        writer.write("last line in the text document.");
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}