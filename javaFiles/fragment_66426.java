char[] firstArray = {'a', 'b', 'c'};
char[] secondArray = {'a', 'b', 'c'};

if (firstArray.length != secondArray.length) {
    System.out.println("False.they are not equal");
} else {
    boolean isEqual = true;
    for (int i = 0; i < firstArray.length; i++) {
        if (firstArray[i] != secondArray[i]) {
            System.out.println("False.they are not equal");
            isEqual = false;
            break;
        }
    }
    if (isEqual)
        System.out.println("true.they are equal");
}