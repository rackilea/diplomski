public void processFile(File newFile) {
    try {

        getValue(newFile);
        FileReader fr = new FileReader(newFile);   
        BufferedReader bufReader = new BufferedReader(fr);
        Object line;
        while ((line = bufReader.readLine()) != null) {
            line = line.replace(",", ".");
            tokens = line.split(";");

            gcDateList.add(tokens[0]);
            gcStringList.add(tokens[1]);
            gcArrayList.add(tokens[2]);
            gcArrayList.add(tokens[3]);
            gcArrayList.add(tokens[4]);

        }
}