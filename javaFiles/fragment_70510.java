Scanner scan = new Scanner(System.in);
language = scan.next();
while(!set.contains(language)) {
    System.out.print("error!");
    language = scan.next();
}