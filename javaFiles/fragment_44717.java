public boolean withdrawal(int units) {
    if(unitsInStore - units >= 0) {
        unitsInStore = unitsInStore - units;
        return true;
    } else {
        System.out.println("Unable to withdraw. Insufficient units in store.");
        return false;
    }
}