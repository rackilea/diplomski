left = 0;
right = 2;

mid = 1;

if (vocabulary[mid].equals(word)){
    // it doesn't
} else if (vocabulary[mid].compareTo("while") > 0) {
    // it doesn't
} else {
    right = mid + 1;
    // this is the same as saying right = 1 + 1, i.e. 2
}