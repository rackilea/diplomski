Scanner input = new Scanner(System.in);
List<String> text = new ArrayList<>();
while (true) {
    String temp = input.nextLine();
    if (temp.isEmpty()) break;
    text.add(temp);
}