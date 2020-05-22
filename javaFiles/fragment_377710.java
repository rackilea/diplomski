File filename = new File("file.txt");
Scanner file = new Scanner(filename);

ArrayList<String> lines = new ArrayList<String>();
while(file.hasNextLine()){
    String line = file.nextLine();
    //You can manipulate the line in here and do whatever you want
    //This can also store the data into an ArrayList for later if you need
    myReverse(line);
    lines.add(line);
}