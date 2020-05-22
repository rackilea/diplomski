//final int SIZE = 1000;
//String[] textBlock = new String[SIZE];

Scanner in = new Scanner(System.in);
String line;

//frequency array for storing which Character is occurs how many times
int[] frequencyArray = new int[26];
Arrays.fill(frequencyArray, 0);

System.out.println("Enter text : ");

// take input un-till find the (.) in a line
// and also count the frequency of Character of current line
while (true) {
    line = in.nextLine();
    for (int i = 0; i < line.length(); i++) {
        char ch = Character.toLowerCase(line.charAt(i));
        if (Character.isLetter(ch)) {
            frequencyArray[ch - 'a']++;
        }
    }
    if (line.contains(".")) {
        break;
    }
}

for (int i = 0; i < 26; i++) {
    System.out.println("Total Number of " + (char)(i + 'a') + " : " + frequencyArray[i]);
}