try(Scanner s=new Scanner(file).useDelimiter("(?<=\n)|(?!\n)(?<=\r)");
    FileWriter out=new FileWriter(tmpFile)) {

    while(s.hasNext()){
        String line=s.next();
        String updatedLine = replaceKeys(line);
        out.write(updatedLine);
    }
}