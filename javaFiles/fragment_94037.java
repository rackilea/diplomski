public static void end() {
    maxIndex = getMaxIndex(numbers);
    System.out.print("\nWell....I guess thanks for using this program?\n");
    System.out.print("\nThe most common bird that you saw was the " + birds[maxIndex] + " with " + numbers[maxIndex] + " being seen in total\n");
    System.exit(0);

}