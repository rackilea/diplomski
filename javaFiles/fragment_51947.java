public static void printlnWithIgnores(String toPrint, Set<Character> ignore) {
    for(char c : toPrint.toCharArray()) {
        if(! ignore.contains(c)) {
            System.out.print(c);
        }
    }
    System.out.println();
}