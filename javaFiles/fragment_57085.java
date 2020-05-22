int number = 30;
ArrayList<Integer> list = allDivisors(number);

System.out.println("The divisors of " + number + " are:");
for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + " ");
}