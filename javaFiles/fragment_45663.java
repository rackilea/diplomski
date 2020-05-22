List<String> generate(String input) {
    ArrayList<String> output = new ArrayList<>();

    this.addFirstDependent(input, output);
    this.addSecondIndependent(output);

    return output;
}