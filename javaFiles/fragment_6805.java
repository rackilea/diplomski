public static int countUniqueCharacters(String input) {
    boolean[] isItThere = new boolean[Character.MAX_VALUE];
    for (int i = 0; i < input.length(); i++) {
        isItThere[input.charAt(i)] = true;
    }

    int count = 0;
    for (int i = 0; i < isItThere.length; i++) {
        if (isItThere[i] == true){
            count++;
        }
    }

    return count;
}