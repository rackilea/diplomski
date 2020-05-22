private static List<Character> randomCharacters;

public static void main(String[] args) {


    //Create List of Char type
    List<Character> randomCharacters = new ArrayList<>();


    //generate random letters and add to the list
    for(int i = 0; i<30; i++){
        int num = (int) (26* Math.random());
        char letter = (char) (num + 'a');
        randomCharacters.add(letter);
    }

    System.out.println( "Unsorted list= " + randomCharacters);

    List<Character> sortedList = randomCharacters.stream()
                                                 .sorted()
                                                 .collect(Collectors.toList());
    System.out.println("Ascending sort: " + sortedList);


    List<Character> reversedList = randomCharacters.stream()
                                                    .sorted(Comparator.reverseOrder())
                                                    .collect(Collectors.toList());
    System.out.println("Sorted Descending: " + reversedList);

    List<Character> uniqueList = randomCharacters.stream()
                                                 .sorted()
                                                 .distinct()
                                                 .collect(Collectors.toList());
    System.out.println("Unique Sort: "+ uniqueList);
}