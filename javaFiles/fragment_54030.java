class NewLineTest {
    public static void main(String[] args) {
        String word = "test\n.";
        System.out.println(word.length());
        System.out.println(word);
        word = word.replace("\n","\n ");
        System.out.println(word.length());
        System.out.println(word);

    }

}