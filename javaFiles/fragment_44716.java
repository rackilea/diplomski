public void withdrawal(int units) {
    if(unitsInStore - units >= 0) {
        unitsInStore = unitsInStore - units;
    } else {
        System.out.println("Unable to withdraw. Insufficient units in store.");
    }
}