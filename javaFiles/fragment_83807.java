for (int i = 0; i < array.length; i += 2) {
        if(i+1 >= array.length) {
            break;
        }
        int temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
    }