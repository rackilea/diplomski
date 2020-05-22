Scanner scan = new Scanner(new File("myFile"));

ArrayList<Task> output = new ArrayList<Task>();

while (scan.hasNext()) {
    String s = scan.next();
    int num1 = scan.nextInt();
    int num2 = scan.nextInt();
    output.add(new Task(s, num1, num2));
}