int[] inputArray = new int[] { 0, 0, 0, 5, 2, 1, 5, 0, 124, 0, 1 };

int offset = 0;

//Find out how many zeros
for (int a : inputArray) {
  if (a != 0) {
    break;
  }
  offset++;
}

//Create an array of the correct size:
int[] outputArray = new int[inputArray.length - offset];

//Copy the array
for (int i = 0; i < outputArray.length; i++) {
  outputArray[i] = inputArray[i + offset];
}

//Only used to confirm solution.
System.out.println(Arrays.toString(inputArray));
System.out.println(Arrays.toString(outputArray));