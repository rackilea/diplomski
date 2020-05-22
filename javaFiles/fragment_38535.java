Scanner sc = new Scanner(System.in);

Map<String, String> morsecode = new HashMap<>();
morsecode.put("a", ",-");
morsecode.put("b", "-...");
// will add other letters later

System.out.println("please enter an english sentence:");
String line = sc.nextLine();
for (char ch : line.toLowerCase().toCharArray()) {
    System.out.print(morsecode.get(Character.toString(ch)) + " ");
}
System.out.println();