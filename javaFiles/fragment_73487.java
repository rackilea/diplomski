public static void main(String[] args) {
    Scanner userInput = null;
    Scanner scanner = null;
    try {
        userInput = new Scanner(System.in);
        scanner = new Scanner(new File("capitals.txt"));
        while (scanner.hasNext()) {
            String[] stateAndCapital = scanner.next().split(",");
            System.out.println(String.format("What is the capital of %s?",
                    stateAndCapital[0]));
            System.out.println(userInput.next().equals(stateAndCapital[1]));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        scanner.close();
        userInput.close();
    }
}