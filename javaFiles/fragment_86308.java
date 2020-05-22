try (Scanner input = new Scanner(System.in)) {
  System.out.print("Enter number of strings: ");
  int a = input.nextInt();

  String arr[] = new String[a];
  for (int i = 0; i < a; i++) {
    System.out.print(String.format("Enter string #%d: ", i + 1));
    arr[i] = input.next();
  }

  for (int i = 0; i < a; i++) {
    for (char c : arr[i].toCharArray()) {
      if (Character.isDigit(c)) {
        System.out.println(c);
      }
    }
  }
}