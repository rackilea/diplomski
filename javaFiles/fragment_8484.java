public class PropertiesEx extends Properties {
    public void load(FileInputStream fis) throws IOException {
        Scanner in = new Scanner(fis);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        while(in.hasNext()) {
            out.write(in.nextLine().replace("\\","\\\\").getBytes());
            out.write("\n".getBytes());
        }

        InputStream is = new ByteArrayInputStream(out.toByteArray());
        super.load(is);
    }
}