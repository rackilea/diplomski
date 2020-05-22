public static void main(String[] args) throws FileNotFoundException {
File tester = new File("./alice2.txt");  // or new File("./src/com/abenson/hw0/three/alice.txt");

System.out.println(tester.getAbsolutePath());

Scanner in = new Scanner(tester);
System.out.println(in.hasNext());
in.close();