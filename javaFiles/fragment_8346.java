// This is the part you already implemented...
int[] array = {10, 2, 2, 3, 5, 6, 1, 32, 123, 2, 32, 32, 32, 1, 23, 123};

// Get Highest
int highest = array[0];
int highestCounter = 1;
for (int i = 1; i < array.length; i++) {
    if (array[i] > highest) {
        highest = array[i];
        highestCounter = 1;
    } else if (array[i] == highest) {
        highestCounter++;
    }
}

System.out.println("Highest = " + highest);
System.out.println("Highest Frequencies = " + highestCounter);

// Get frequencies 
int[] freqArray = new int[array.length];
for (int i = 0; i < array.length; i++) {
    int counter = 0;
    for (int j = 0; j < freqArray.length; j++) {
        if (array[i] == array[j]) {
            counter++;
        }
    }
    freqArray[i] = counter;
}

// Finally display result
for (int i = 0; i < freqArray.length; i++) {
    System.out.println(array[i] + " = " + freqArray[i]);
}