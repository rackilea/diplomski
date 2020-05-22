public void addElement(ClassB element) {
        if (index >= array.length) {
            throw new TooManyElementsException();
        }

        array[index++] = element;
    }