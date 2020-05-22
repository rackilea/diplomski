public void dequeue() {

        size--;

        System.out.println(arr[popped] + " removed");

        if (size <= capacity / 3) {

            capacity = capacity / 2;

            int[] nArr = new int[capacity];

            for (int i = 0; i < size; i++)
                nArr[i] = arr[i];

            arr = nArr;

        }

        int[] nArr = new int[capacity];

/*      for (int i = 0; i < popped; i++)
            nArr[i] = arr[i]; //Not required as popped is always 0
*/
        for (int i = popped + 1; i < size; i++)
            nArr[i - 1] = arr[i];

        arr = nArr;

        //popped++; // not required as we remove first element

    }