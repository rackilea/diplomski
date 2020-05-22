public class Example {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Example.class.getResourceAsStream("/META-INF/MANIFEST.MF")));
        String line;
        do {
            line = br.readLine();
            if (line != null) System.out.println(line);
        } while (line != null);
    }
}