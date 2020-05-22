public static ArrayList<Integer> processArray(ArrayList<Integer> array) {
    for (int i = 0; i < array.size() - 1; i++) { // don't process last value (it has no next value)
        if (array.get(i) % 2 == 0 && array.get(i+1) % 2 == 0) {
            int sum = array.get(i) + array.get(i+1); // add current and next value
            array.set(i, sum); // update current value
            array.remove(i+1); // remove next value
            i--; // make sure we re-process current value, to compare with "new" next value
        }
    }
    return array; // return modified array
}