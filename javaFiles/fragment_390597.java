public static void main (String[] args) {
    String text = "Hello, my identification is Mister Dude.";
    String[] words = text.replaceAll("[^(\\w )]+", "").toLowerCase().split(" ");
    for (String word : words) {
        if (word.length() <= 4) {
            System.out.println(word);
        } 
        else {
            for (int i = 0; i <= word.length() - 4; i++) {
                System.out.println(word.substring(i, i + 4));
            }
        }
    }
}