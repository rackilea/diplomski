public class Test {
    public static void main(String[] args) throws IOException {
        if(args.length != 2)
            throw new IllegalArgumentException("Illegal number of arguments.  Usage:\n\t java foo.bar.Test <sourceFile> <destFile> ..");

        Path source = Paths.get(args[0]);
        Path destination = Paths.get(args[1]);
        try(
            BufferedReader reader = Files.newBufferedReader(source, Charset.defaultCharset());
            PrintWriter writer = new PrintWriter(Files.newBufferedWriter(destination, Charset.defaultCharset()));
        ) {
            int lineNumber = 1;
            String line = null;
            while((line = reader.readLine()) != null) {
                writer.format("/%d/%s%n", lineNumber++,line);
            }
        }

    }
}