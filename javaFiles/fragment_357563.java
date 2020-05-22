String prev = null;
String curr = null;

Scanner sc = new Scanner(new File("thefile.csv"));

if (sc.hasNextLine()) {
    curr = sc.nextLine();
}

while (sc.hasNextLine()) {
    prev = curr; 
    curr = sc.nextLine();
}