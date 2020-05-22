BufferedReader reader = new BufferedReader(new FileReader("somefile.txt"));
    int ch;
    char charToSearch='a';
    int counter=0;
    while((ch=reader.read()) != -1) {
        if(charToSearch == (char)ch) {
            counter++;
        }
    };
    reader.close();

    System.out.println(counter);