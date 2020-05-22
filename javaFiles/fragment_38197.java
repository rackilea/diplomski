static int[] counts = new int[26]; {{
       Arrays.fill(counts, 0);  //Fill the array with zeroes
}}
static String alph = "abcdefghijklmnopqrstuvwxyz";     

    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintStream output = new PrintStream(new File("output.txt"));
        while (input.hasNextLine()) {
            String fjala = input.next();
            countLetters(fjala);
        }
        for(int i =0; i < counts.length; i++) {
            output.println(alph.charAt(i) + " : " + counts[i]);
        }
    }
    public static void countLetters(String text) {

        for (int i = 0; i < alph.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (alph.charAt(i) == text.charAt(j)) {
                    counts[i]++;
                }
            }
        }
    }