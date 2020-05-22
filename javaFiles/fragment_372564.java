// generate your random string
Random r = new Random();
String s = String.valueOf((char)(r.nextInt(26) + 'a')); // generate random char a-z

// test if the user input is equal to your random string
Scanner sc = new Scanner((System.in));
String character = sc.nextLine();
System.out.println((character.equals(s) ? "Correct": "Incorrect");