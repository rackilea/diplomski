public class Example {

    private static final String PREFIX = "\\d+/";
    private static final String SUFFIX = "/.*-";

    public static void main(String[] args) throws IOException{
        File target = new File("target.txt");
        FileWriter fileWriter = new FileWriter(target);

        File source = new File("source.txt");
        FileReader fileReader = new FileReader(source);
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line.replaceFirst(PREFIX, "").replaceFirst(SUFFIX, " -"));
                fileWriter.write("\r\n");
            }
        }  finally {
            fileReader.close();
            fileWriter.close();
        }
    }
}