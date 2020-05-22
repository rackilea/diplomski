public class FileParse {

    private static final int FLUSH_LIMIT = 1024 * 1024;
    private static StringBuilder outputBuffer = new StringBuilder(
            FLUSH_LIMIT + 1024);
    private static final long countCellId;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String fileName = "i:\\1\\2.txt";
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ";|, ");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                processToken(token);
            }
        }
        flushOutputBuffer();
        System.out.println("----------------------------");
        System.out.println("CELLID Count: " + countCellId);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    private static void processToken(String token) {
        if (token.startsWith("CELLID=")) {
            String value = getTokenValue(token);
            outputBuffer.append("CELLID:").append(value).append("\n");
            countCellId++;
        } else if (token.startsWith("ENSUP=")) {
            String value = getTokenValue(token);
            outputBuffer.append("ENSUP:").append(value).append("\n");
        } else if (token.startsWith("ENCHO=")) {
            String value = getTokenValue(token);
            outputBuffer.append("ENCHO:").append(value).append("\n");
        }
        if (outputBuffer.length() > FLUSH_LIMIT) {
            flushOutputBuffer();
        }
    }

    private static String getTokenValue(String token) {
        int start = token.indexOf('=') + 1;
        int end = token.length();
        String value = token.substring(start, end);
        return value;
    }

    private static void flushOutputBuffer() {
        System.out.print(outputBuffer);
        outputBuffer = new StringBuilder(FLUSH_LIMIT + 1024);
    }

}