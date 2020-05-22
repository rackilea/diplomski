Scanner s = new Scanner(inputFile);
List<Integer> extractedIntegers = new ArrayList<>();
while (s.hasNextInt()) {    // check if the line starts with an integer
    extractedIntegers.add(s.nextInt()); 
    s.nextLine(); //consumes the rest of the line in order to skip over the comments
}
s.close();