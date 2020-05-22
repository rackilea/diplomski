Stack<BigInteger> stack = new Stack<BigInteger>();
System.out.println("Please write some pairs of numbers to add by a space: ");

Scanner input = new Scanner(System.in);

for (BigInteger number : input.nextLine().split(" "))
{

BigInteger result = new BigInteger("0");
while (!stack.isEmpty()) {
    result.add(stack.pop());
}
System.put.println("Result : " + result);