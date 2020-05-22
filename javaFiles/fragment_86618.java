// Create a list containing numbers 1 till 5
List<Integer> numbers = new ArrayList<Integer>();
for(int i = 1; i < 6; i++) {
  numbers.add(i);
}

Random random = new Random();

// Randomly get the index of your first number, this will be a number 
// between 1 and 4
int firstIndex = random.nextInt(4);
int number1 = numbers.get(firstIndex);

// Remove that number from the list, your list now becomes size 4, and no 
// longer contains the first number you picked.
numbers.remove(firstIndex);

// Randomly get the index of your second number, this will be a number 
// between 1 and 5 without the number picked earlier.
int secondIndex = random.nextInt(4);
int number2 = numbers.get(secondIndex);

System.out.println(number1);
System.out.println(number2);