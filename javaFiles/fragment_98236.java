public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    ArrayList<String> words = new ArrayList<String>();

    System.out.println("Enter the words or write STOP to exit:");
    while (in.hasNext()) {
        String inputLine = in.nextLine();
        if (inputLine.equalsIgnoreCase("STOP")) {
            break;
        }
        words.add(inputLine);
    }

    Collections.sort(words);

    System.out.println("The words sorted:");
    System.out.println(words);

    in.close(); // Don't forget to close the stream !!
}