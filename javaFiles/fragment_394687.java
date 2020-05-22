public String printOut() {
    while (true) {
        for (int i = 0; i < 10; i++) {

            String value = (animalArray[i] + " says " + noiseArray[i] + ".");
            printArray[i] = value;
            System.out.println();
            System.out.println(printArray[i]); // This works
            break;
        }
    }
    System.out.println(Arrays.toString(printArray); // Also works
}