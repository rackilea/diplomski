//to store the counts
for (int r : randomArray)
    countArray[r]++;

//to access the counts
for (int x = 0; x < countArray.length; x++) {
    System.out.println("" + x + " occurs " + countArray[x] + " times");
}