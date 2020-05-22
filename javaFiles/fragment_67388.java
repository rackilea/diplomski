public static void main(String[] args) throws IOException {

    ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "SET");
    Map<String, String> env = pb.environment();
    env.put("MYVAR", "myValue");
    Process p = pb.start();
    InputStreamReader isr = new InputStreamReader(p.getInputStream());
    char[] buf = new char[1024];
    while (!isr.ready()) {
        ;
    }
    while (isr.read(buf) != -1) {
        System.out.println(buf);
    }
}