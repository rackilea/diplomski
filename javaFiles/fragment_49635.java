public void content(String s) throws IOException { 
        try (BufferedReader br = new BufferedReader(new FileReader(s));
                PrintWriter pr = new PrintWriter(new File("e:\\OP.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                pr.println(line);
            }
        }
}