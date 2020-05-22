for (index = 0; index < array.length - 1; index++) {
    if (array[index] == array[index + 1]) {
        counter++;
    } else {
        if (counter > 1) {
            System.out.println("element " + array[index] + " repeats " + counter + " times");
        }
        counter = 1;
    }
}