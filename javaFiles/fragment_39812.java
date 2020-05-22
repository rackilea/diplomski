public int[] orderIndexAscending(int[] array) {
        int[] minimumIndexes = new int[array.length];
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        Set<Integer> savedIndexes = new HashSet<>();

        for (int index = 0; index < array.length; index++){
            int minIndex = 0;
            // Add the index in ascending order, we need to keep the indexes already
            // saved, so won't miss indexes from repeted values
            for (int number : array) {
                if (number == sortedArray[index] && !savedIndexes.contains(minIndex)) { 
                    savedIndexes.add(minIndex);
                    minimumIndexes[index] = minIndex;
                    break;
                }
                minIndex++;
            }
        }
        return minimumIndexes;
    }
}