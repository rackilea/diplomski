public static byte [] input(Scanner sc) {
    ByteArrayOutputStream inArray= new ByteArrayOutputStream();

    System.out.println("enter a sequence of bytes please! ");
    System.out.println("non-int will terminate the input!");

    while (sc.hasNext()) {
        byte i;
        try {
            i = sc.nextByte();
            inArray.write(i);
        } catch (InputMismatchException e) {
            System.out.println("input terminated!");
            break;
        }
    }
    System.out.println(Arrays.toString(inArray.toByteArray()));
    return inArray.toByteArray();
}