final String dosCommand = "cmd /c cmd.exe /K";
    final String location = "\"C:/Program Files/.../abc.bat\"";
    final String trail = "d:\\xyz.txt";
    try {
        final Process process = Runtime.getRuntime().exec(
                dosCommand + " " + location + " " + "pro_wait" + " " + trail,
                null, new File("D:\\"));
        final InputStream in = process.getInputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            System.out.print((char) ch);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }