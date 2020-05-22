FileReader fr = new FileReader(//the txt file mentioned above); 
Scanner s = new Scanner(fr);
while (s.hasNext()){
    String paragraph = new String();
    while(s.hasNext()) {
        String line = s.next();
        if (line.length() == 0)
            break;
        if (paragraph.length() != 0)
            paragraph = paragraph + "\n";
        paragraph = paragraph + "\n" + line;
    }
    // Do something with paragraph here...           
}