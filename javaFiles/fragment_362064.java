double average = 0;
int[] storedSums = new int[6];

int i = 0;
for (Map.Entry<Integer, Integer> entry : rolls.entrySet()) {
    int sum = entry.getValue();
    average += sum;
    storedSums[i++] = sum;
    System.out.println(entry.getKey() + ": " + sum);
}

Arrays.sort(storedSums);

System.out.println("Average: " + (average / 6));
System.out.println("Median: " + storedSums[2]);