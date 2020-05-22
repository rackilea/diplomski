Scanner scan = new Scanner(System.in);
System.out.println("How many names would you like to enter?");
int n = scan.nextInt();
scan.nextLine();
System.out.println("Enter the " + n + " names: ");
List<String> names = new ArrayList<>();
for (int i = 0; i < n; i++) {
    names.add(scan.nextLine());
}
Collections.shuffle(names);
for (int i = 0; i < n; i += 2) {
    System.out.print(names.get(i));
    if (i + 1 < n) {
        System.out.print(" & " + names.get(i + 1));
    }
    System.out.println();
}