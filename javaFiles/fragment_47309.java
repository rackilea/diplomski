try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();
    int lineCounter = 0;

    while (line != null) {
        lineCounter++;
        if(lineCounter > 1){
            gridPane.addRow(lineCounter-1, nodeThatYouWant);
        }
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    String everything = sb.toString();
}