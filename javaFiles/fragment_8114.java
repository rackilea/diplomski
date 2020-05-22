public String readFileAsString(String inputFile) throw IOException {
    BufferedReader br = new BufferedReader(new FileReader(inputFile));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }

        return sb.toString();
    } finally {
        br.close();
    }

}