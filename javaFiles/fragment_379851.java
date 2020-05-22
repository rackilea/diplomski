public void new_file_with_text(String text, String fname) {
    File f = null;
    try {
        f = new File(fname);
        f.createNewFile();
        System.out.println(text);           
        PrintWriter out = new PrintWriter(f, "UTF-8");
        try {
            out.print(text);
        } finally {
            out.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}