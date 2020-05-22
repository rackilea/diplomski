public static void main(String[] args) throws Exception {
    try(BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
        String line = null;
        List<String> idList = new ArrayList<String>();

        while((line = br.readLine()) != null) {
            System.out.println(line); // you already printing it
            String[] tokens = line.split("\\s*,\\s*"); // assuming your line is like this --> 123, Pushpesh, Rajwanshi
            if (tokens.length > 0) {
                idList.add(tokens[0]); // ID will be accessed at zero index
            }
        }

        idList.forEach(System.out::println);
    }

}