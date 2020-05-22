public static void main(String[] args) throws IOException {

    System.out.println("First number:");
    float i = input.nextInt();

    System.out.println("Choose operator +, -, *, /");
    char s = input.next().charAt(0);

    System.out.println("Second number:");
    float z = input.nextInt();


    Map<String, Operation> operationMap = new HashMap<String, Operation>();
    operationMap.put("+", new Addition());
    operationMap.put("-", new Substraction());
    ...

    Operation op = operationMap.get(s);

    System.out.println("Result= " + op.getResult(i, z));
    System.in.read();

}