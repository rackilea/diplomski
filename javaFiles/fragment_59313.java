Scanner sc = new Scanner(System.in);
String line = sc.nextLine();
for (String token : line.split("\\s+")) {
    list.add(Integer.parseInt(token));
}
// your for loop here...