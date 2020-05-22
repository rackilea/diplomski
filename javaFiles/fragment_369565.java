try(BufferedReader br = new BufferedReader(new FileReader(infile));
    PrintWriter bw = new PrintWriter(new FileWriter(outfile))) {
    for(String line; (line = br.readLine()) != null;) {
        String json = process(line);
        bw.println(json);
    }
}