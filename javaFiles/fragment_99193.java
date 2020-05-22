public class EncodingTest {
    public static String read(String file, String encoding) throws IOException {
        StringBuffer fileData = new StringBuffer(1000);

        /* Only difference with OP code */
        /* I use *explicit* encoding while reading the file */
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), encoding)
                );

        char[] buf = new char[5000];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();     
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("UTF-8-BOM-FILE", "UTF-8"));
        System.out.print(read("UTF-8-FILE", "UTF-8"));
        System.out.print(read("UTF-8-BOM-FILE", "ISO-8859-15"));
        System.out.print(read("UTF-8-FILE", "ISO-8859-15"));
    }
}