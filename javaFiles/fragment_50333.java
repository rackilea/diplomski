int counter = 0;
for(int i=0;i< array.length; i++) {
    if (array[i] > arithmeticmean) {
        counter++;
        System.out.println(array[i]);
    }
}
System.out.println("Amount of items that are greater than arithmetic mean: " + counter);