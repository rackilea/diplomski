String inputText =
        "Line1 a b\n" +
        "Line2 d e f\n" +
        "Line3";
    Scanner input = new Scanner(inputText);
    while (input.hasNext()) {
        Scanner line = new Scanner(input.nextLine());
        System.out.println("[" + line.next() + "]");
        while (line.hasNext()) {
            System.out.println("  " + line.next());
        }
    }