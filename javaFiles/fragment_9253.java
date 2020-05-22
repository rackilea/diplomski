while (counter < heltall.length) {
    // if the number is negative, replace it with its index
    if (heltall[counter] < 0) {
        heltall[counter] = counter;
    }
    counter++;
}
// outside the loop
System.out.println(Arrays.toString(heltall));