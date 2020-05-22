class Main {
    public static void main(String[] args) {
        String str = "aasbkllzzzs";

        // create frequency table for 128 - ASCII Characters
        int[] freq = new int[128];

        // For each character, increment count in the frequency table
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        System.out.println("Frequencies : ");
        for (int i = 0; i < freq.length; i++) {
            // Print results for which count > 0
            // (char) i => Character
            // freq[i] => Frequency of character
            if (freq[i] != 0) {
                System.out.println("Char : " + (char) i + ", Count : "
                        + freq[i]);
            }
        }
    }
}