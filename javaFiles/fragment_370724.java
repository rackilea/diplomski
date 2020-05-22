public static char readTypeOfConsumer() {
    Scanner kbd = new Scanner(System.in);
    boolean typeCodeInvalid = true;

    char typeCode;
    do {
        typeCodeInvalid = false;
        System.out.println(
                "Enter the type consumer< you may type r for  residential or c for commercial>:");
        typeCode = kbd.next().toLowerCase().charAt(0);
        if (typeCode == 'r') {
            System.out.println("type: Residential");
        } else if (typeCode == 'c') {
            System.out.println("type: Commercial");
        } else {
            typeCodeInvalid = true;
        }

    } while (typeCodeInvalid);

    return typeCode;
}