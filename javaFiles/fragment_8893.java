String inputString;
Scanner in = new Scanner(System.in);
while (true) {
    System.out.print("jcp>");
    inputString = in.nextLine();
    String[] tokens = inputString.split(" ");
    switch (tokens[0]) {
        case "n":
        case "new":
            createNewInstance(tokens);
            break;
        case "c":
        case "call":
            callMethod(tokens);
            break;
        case "p":
        case "print":
            Object obj = hashMap.get(tokens[1]);
            print(obj);
            break;
        case "e":
        case "x":
        case "exit":
            return;
        default:
            System.out.println("Illegal command!");
            break;
    }
}