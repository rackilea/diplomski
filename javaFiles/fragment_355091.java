@SuppressWarnings("resource") Scanner scanner = new Scanner(System.in);

System.out.print("Enter a string:\t");
String word = scanner.nextLine();

System.out.print("Enter a character:\t");
String character = scanner.nextLine();

char charVar = 0;
if (character.length() > 1) {
    System.err.println("Please input only one character.");
} else {
    charVar = character.charAt(0);
}

int count = 0;
for (char x : word.toCharArray()) {
    if (x == charVar) {
        count++;
    }
}

System.out.println("Character " + charVar + " appears " + count + (count == 1 ? " time" : " times"));