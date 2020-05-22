private static void fileCopy(String from, String to) {
    FileChannel fromCh = null;
    FileChannel toCh = null;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    try {
        fin = new FileInputStream(new File(from));
        fromCh = fin.getChannel();
        fout = new FileOutputStream(new File(to));
        toCh = fout.getChannel();

        fromCh.transferTo(0, fin.available(), toCh);

    } catch (IOException e) {

        e.printStackTrace();
    } finally {
        if (fin != null)
            try {
                fin.close();
            } catch (IOException e) {

            }
        if (fout != null)
            try {
                fout.close();
            } catch (IOException e) {

            }

    }
}