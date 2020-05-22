static void printWords(List<Vector<String>> bigVector) {
    printWords(bigVector, "");
}
static void printWords(List<Vector<String>> bigVector, String accumulator) {
    if(bigVector.isEmpty()) {
        System.out.println(accumulator);
    }
    else {
        for(String word : bigVector.get(0)) {
            printWords(bigVector.subList(1, bigVector.size()), accumulator + " " + word);
        }
    }
}