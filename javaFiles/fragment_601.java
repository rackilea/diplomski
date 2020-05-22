int[] rangeFrequency = new int[10];

for (int elem: element) {
    int bucket = elem / 10;
    rangeFrequency[bucket] += 1;
}

// Print frequency from array:
for (int i = 0; i < rangeFrequency.length; ++i) {
    System.out.print("Frequency in range : [" + i * 10 + ", " + 
                                                 (i * 10 + 9) + ") --> ");
    System.out.println(rangeFrequency[i]);
}