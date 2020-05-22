public boolean sameAsFirstElem(int[] array) {
        boolean isEqual = false;
        int firstElem = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == firstElem) {
                return true;
            }
        }
        return isEqual;
    }