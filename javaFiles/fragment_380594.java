public static void main(String[] args) {
    for (String word : new String[]{"Motho", "Botswana"}) {
        System.out.println("Word " + word + " Syllables " 
                + Arrays.toString(word.split("(?<=[aeiou])")));
    }
}