public class Test {
    public static void main(String[] args) throws Exception {
        addNumber();
    }

    public static void addNumber() throws Exception {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Number: ");

        if (input.hasNextInt()) {
            number = input.nextInt();
        } else {
            throw new Exception(
                "Error\n\t**This version only supports input of numbers**");
        }

        Integer integer = number; // Type missmatch
        System.out.println(integer);
    }
}