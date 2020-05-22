public static void removeLine(String filename, String line) {
    File from = new File(filename);
    File tmp = new File(filename + ".tmp");
    PrintWriter pw = null;
    BufferedReader br = null;
    try {
        pw = new PrintWriter(tmp);
        br = new BufferedReader(new FileReader(from));
        boolean found = false;
        for (String line2; (line2 = br.readLine()) != null; )
            if (line2.equals(line))
                found = true;
            else
                pw.println(line2);
        pw.close();
        br.close();
        if (found) {
            from.delete();
            tmp.renameTo(from);
        } else {
            tmp.delete();
        }
    } catch (IOException e) {
        // log error.
        try { if (br != null) br.close(); } catch (IOException ignored) { }
        if (pw != null) pw.close();
    }
}