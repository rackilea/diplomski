List<Integer> positivesList = new ArrayList<Integer>();
List<Integer> negativesList = new ArrayList<Integer>();

for (int i = 0; i < array.length; i++) {
    if (array[i] >= 0) {
        positivesList.add(array[i]);
    } else {
        negativesList.add(array[i]);
    }
} 
int[] positive = positivesList.toArray(new int[positivesList.size()]);
int[] negative = negativesList.toArray(new int[negativesList.size()]);