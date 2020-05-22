public class ExtensibleEnumOperationTest
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number (i.e. 1.43): ");
        double x = input.nextDouble();
        System.out.print("Enter another number: ");
        double y = input.nextDouble();
        input.close();
        System.out.println();
        System.out.println("Testing Basic Operations using Bounded Type Token (Item 29)");
        test(BasicOperation.class, x, y);

        System.out.println("Testing Basic Operations using Bounded Wildcard Type (Item 28)");
        test(Arrays.asList(BasicOperation.values()), x, y);

        System.out.println("Testing a single operation:");
        Operation op = BasicOperation.PLUS;
        System.out.println(x + " + " + y + " = " + op.apply(x, y));     
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet,
        double x, double y)
    {
        for (Operation op : opSet.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        System.out.println();
    }

    private static void test(Collection<? extends Operation> opSet, double x,
            double y)
    {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        System.out.println();
    }
}