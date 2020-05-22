public class DogSorter {

    public void sort(ArrayList<Dog> dogs) {
        dogs.sort(new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                int comparison = 0;
                comparison = Double
                        .valueOf(d1.getTailLength())
                        .compareTo(d2.getTailLength());
                if (comparison == 0) {
                    comparison = String
                            .valueOf(d1.getName())
                            .compareTo(d2.getName());
                }
                return comparison;
            }
        });
    }

    public void selectionSort(ArrayList<Dog> dogs) {
        int n = dogs.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                Dog d1 = dogs.get(j);
                Dog d2 = dogs.get(min_idx);
                int comparison = Double
                        .valueOf(d1.getTailLength())
                        .compareTo(d2.getTailLength());
                if (comparison == 0) {
                    comparison = String
                            .valueOf(d1.getName())
                            .compareTo(d2.getName());
                }
                if (comparison < 0)
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element

            // using built in swap
            // Collections.swap(dogs, min_idx, i);

            // using classic temp method
            Dog temp = dogs.get(min_idx);
            dogs.set(min_idx, dogs.get(i));
            dogs.set(i, temp);

            // using classic method without temp element
            // dogs.set(i, dogs.set(min_idx, dogs.get(i)));
        }
    }
}