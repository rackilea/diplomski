String vowels = "aeiou";
int[] counters = new int[vowels.length()];

Scanner console = new Scanner(System.in);
System.out.print("Input file: ");
String inputFileName = console.nextLine().trim();
try (Scanner scan = new Scanner(new File(inputFileName))) {
    while (scan.hasNextLine()) {
        for (char ch : scan.nextLine().toLowerCase().toCharArray()) {
            int p = vowels.indexOf(ch);
            if (p >= 0) {
                counters[p]++;
            }
        }
    }
}
for (int i = 0; i < vowels.length(); i++) {
    System.out.printf("%c: %d%n", vowels.charAt(i), counters[i]);
}