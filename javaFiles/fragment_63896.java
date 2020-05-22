public class ParseLogin {

    /**
     * Parses lines of username password pairs delimited by ';' and returns a Map
     * username->password.
     *
     * @param reader source to parse
     * @return Map of username->password pairs.
     * @throws IOException if the reader throws one while reading.
     */
    public static Map<String, String> parse(Reader reader) throws IOException {

        Map<String, String> result = new LinkedHashMap<String, String>();
        BufferedReader br = new BufferedReader(reader);
        String line;
        while (null != (line = br.readLine())) {
            String fields[] = line.split("\\s*;\\s*");
            if (fields.length > 1) {
                result.put(fields[0], fields[1]);
            } // else ignore (or throw Exception)
        }
        return result;
    }


    public static void main(String[] args) {

        try {
            Map<String, String> result = parse(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.format("%s not found.\n", args[0]);
            System.exit(1);
        } catch (IOException e) {
            System.out.format("Error while reading from %s.\n", args[0]);
            e.printStackTrace();
            System.exit(2);
        }
    }
}