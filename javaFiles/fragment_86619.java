// Create a list containing numbers 1 till 5 -> might want to extract this
// from the method so you don't have to rebuild the array over and over 
// again each call...
List<Integer> numbers = new ArrayList<Integer>();
for(int i = 1; i < 6; i++) {
  numbers.add(i);
}

// Shuffle the array randomly
Collections.shuffle(numbers);

// Get the first 2 numbers from the array
int number1 = numbers.get(0);
int number2 = numbers.get(1);

// If number1 equals 5, swap number1 and number2 as you want number1 to be 
// 1-4 and number2 to be 1-5
if(number1 == 5) {
  number1 = number2;
  number2 = 5;
}

System.out.println(number1);
System.out.println(number2);