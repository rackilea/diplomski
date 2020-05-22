Scanner in = new Scanner(System.in);
System.out.println("please enter a file name");
String filename = in.nextLine();
in.close();
File file = new File(filename);
ArrayList<String> list = new ArrayList(); // Cant use a regular array because the length is unknown.
BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line = br.readLine()) != null) {
    list.add(line);
}
br.close();