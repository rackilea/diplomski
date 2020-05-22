public static void main(String[] args) throws Exception {
        String word = "abcdefg";
        System.out.println(word.length());
        System.out.println(word.replace("a", "").length());
        int a_counter = word.length() - word.replace("a", "").length();
        System.out.println(a_counter);
    }