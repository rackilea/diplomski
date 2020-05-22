public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String string = input.nextLine();
    Map<Character, Integer> sortedMap = sortByComparator(countFrequency(string));
    for (Entry<Character, Integer> entry : sortedMap.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}