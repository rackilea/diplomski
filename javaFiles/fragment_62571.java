Scanner input = new Scanner(System.in);
int points = 0;
String value = input.nextLine(); // give 500

String[] tokens = value.split(" ");

if (tokens[0].equalsIgnoreCase("give")) {
   points += Integer.parseInt(tokens[1]);
}

System.out.println(points); // 500