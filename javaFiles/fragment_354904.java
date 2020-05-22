public class MyClass {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String className = MyClass.class.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = MyClass.class.getClassLoader().getResourceAsStream(classAsPath);
        byte[] buffer = new byte[8];
        int r = stream.read(buffer);
        if (r < 8) {
            throw new IOException("Something wrong we could read only " + r + " bytes");
        }
        int major = buffer[6];
        int minor = buffer[7];
        int version = (major << 8);
        version = version | minor;
        System.out.printf("Version (major %X, minor %X) -> %X", major, minor, version);
    }
}