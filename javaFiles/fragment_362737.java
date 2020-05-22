public class SaveStateTesing {

    private static final String FILE_NAME = "C:\\Users\\Nicolas\\Desktop\\save.txt";

    public static void main(String[] args) throws IOException {
        saveState("helloWorld", FILE_NAME);
        String state = readState(FILE_NAME);
        System.out.println(state);
    }

    private static void saveState(String state, String fileName) throws IOException {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            writer.println(state);
        }
    }

    private static String readState(String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.readLine();
        }
    }

}