File file = new File("file.txt");
String word = "abc";
Scanner scanner = null;

try {
    scanner = new Scanner(file);
} catch(FileNotFoundException e) { 
   //handle this
}

//now read the file line by line
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if(line.contains(word)) { 
        System.out.println(line);
    }
}
scanner.close();