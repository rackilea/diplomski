for (String aY : y) {
    int count = 0;
    for (String aX : x) {
        if (aY.contains(aX)) {
            count++;
        }
    }
    System.out.println(aY + ": " + count);
    //no need to reset the count
}