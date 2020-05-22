private void partition(int start, int end) {
        if (end <= start) {
            return;
        }
        int k = end;
        int i = start;
        int j = end - 1;
        while (i < j) {
            // left is in place
            while (i < j && array[i] < array[k]) {
                i++;
            }
            // right is in place
            while (i < j && array[j] >= array[k]) {
                j--;
            }

            // both are not good
            if (i < j) {
                // swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        // swap left and pivot
        if (array[i] >= array[k]) {
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
        partition(start, i - 1);
        partition(i + 1, end);
}