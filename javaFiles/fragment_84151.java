public static void main(String[] args) throws IOException {

    System.out.println("First number:");
    float i = input.nextInt();

    System.out.println("Choose operator +, -, *, /");
    char s = input.next().charAt(0);

    System.out.println("Second number:");
    float z = input.nextInt();

    Operation op = null;
    switch (s) {
    case '+':
        op = new Addition();
        break;
    case '-':
        op = new Subtraction();
        break;
            ...
    }

    System.out.println("Result= " + op.getResult(i, z));
    System.in.read();
}