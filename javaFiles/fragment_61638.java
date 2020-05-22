public boolean Insert(String value){
    boolean result = false;
            int index = 0;
            if (numUsed < length) {
                while (index <= numUsed) { // Here the first time numUsed = 0, index = 0, index <= numUsed;
                    int compare = storage[index].compareTo(value); // The first time, storage[0] == null; NullPointException is thrown
                    if (compare < 0)
                        index++;
                }
                moveItemsDown(index);
                storage[index] = value;
                numUsed++;
                result = true;
            }
            return result;
}