public static void main(String[] data) {
    ArrayList<Character> chars = new ArrayList<>(4);
    chars.add('a');
    chars.add('b');
    chars.add('c');
    chars.add('d');
    System.out.println(getPermutations("", chars));

}

private static ArrayList<String> getPermutations(String currentResult, ArrayList<Character> possibleChars) {
    ArrayList<String> result = new ArrayList<>(possibleChars.size());
    for (char append: possibleChars) {
        String permutation = currentResult + append; //create a new string with an additional character
        result.add(permutation); //add the permutation to the result
        if (possibleChars.size() > 0) {
            //make a new list with the appendable characters
            ArrayList<Character> possibleCharsUpdated = (ArrayList)possibleChars.clone();
            //from that list, exclude the character we just appended
            possibleCharsUpdated.remove(new Character(append));
            //merge the result of a recursive call of this method and the result we already had
            result.addAll(getPermutations(permutation, possibleCharsUpdated));
        }
    }
    return result;
}