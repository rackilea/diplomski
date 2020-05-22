Scanner scanner = new Scanner(System.in);
while (true) {
   String line = scanner.nextLine().trim();
   if (line.equals("uuidcreaterandom")) {
      UUID uuid = UUID.randomUUID();
      String str = uuid.toString();
      System.out.println(str);
   }
}