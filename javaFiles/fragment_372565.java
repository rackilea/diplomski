// generate your random string
String s = String.valueOf(generateRandomChars("abcdefghijklmnopqrst‌​uvwxyz", 1));

// test if the user input is equal to your random string
Scanner sc = new Scanner((System.in));
String character = sc.nextLine();
System.out.println((character.equals(s) ? "Correct": "Incorrect");