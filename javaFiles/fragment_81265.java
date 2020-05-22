public boolean hasWord(String input, String word) {
    return input.matches(".*\\b" + word + "\\b.*"));
}

// now call the above method from somewhere
public static void main (String[] args) {
    String [] skoal = {"THE", "BE", "TO", "OF", "AND", "A", "IN",
                       "THAT", "I", "IT", "ON", "IN", "BUT", "IS", "WITH"};
    String zach = "...";           // your original content
    zach = zach.replace(",", "");  // remove punctuation
    zach = zach.replace(".", "");
    zach = zach.toUpperCase();     // uppercase

    for (String stop : skoal) {
        if (hasWord(stop)) {
            System.out.println(word + " true");
        }
        else {
            System.out.println(word + " false");
        }
    }
}