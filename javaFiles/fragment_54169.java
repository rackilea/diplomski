Collections.sort(myList, new Comparator<Myclass>() {

    public int compare(Myclass o1, Myclass o2) {
        // I don't know how you access the first integer in your 'MyClass'
        // replace by your own.
        int number1 = o1.getFirstElement();
        int number2 = o2.getFirstElement();
        if (number1  < number2 ) {
            return -1;
        } else if (number1  > number2 ) {
            return 1;
        } else {
            return 0;
        }
    }
});