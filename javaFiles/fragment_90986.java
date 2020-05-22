public void bubbleSort() {

        for (int i = arraySize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j + 1])
                    swap(j, j + 1);

            }
        }

    }