public static void main(String[] args) {
    String[] input = {"a^100", "b^200", "c^150"};
    List<String> inputList = Arrays.asList(input);
    Collections.sort(inputList, new IntegerSubstringCompare());
    System.out.println(inputList);
}