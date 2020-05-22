public void addElement(ClassB element) {
        int index = 0;

        while (index < array.length && array[index] != null) {
            index++;
        }

        if (index >= array.length) {
            throw new TooManyElementsException();
        }

        array[index] = element;
    }