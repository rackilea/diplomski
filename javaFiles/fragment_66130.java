/**
 * main
 */
public static void main(String[] args) {
    try {
        System.out.println("start");

        final String inf = "d:/testfile.pdf";
        final String outf = "d:/testfile.tmp.pdf";
        final FileOutputStream out = new FileOutputStream(outf) {
            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                super.write(b, off, len);
                try {
                    // We delay the write by a few millis to give the progress bar time to kick in
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        putFile(inf, out);

        System.out.println("end");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

private static boolean putFile(String m_sLocalFile, OutputStream out /*FtpClient m_client*/) {
    boolean success = false;
    int BUFFER_SIZE = 10240;
    if (m_sLocalFile.length() == 0) {
        System.out.println("Please enter file name");
    }
    byte[] buffer = new byte[BUFFER_SIZE];
    try {
        File f = new File(m_sLocalFile);
        int size = (int) f.length();
        System.out.println("File " + m_sLocalFile + ": " + size + " bytes");
        System.out.println(size);
        FileInputStream in = new FileInputStream(m_sLocalFile);
        //test
        InputStream inputStream = new BufferedInputStream(
                      new ProgressMonitorInputStream(null,"Uploading " + f.getName(),in));

        //test
        //OutputStream out = m_client.put(f.getName());

        int counter = 0;
        while (true) {
            int bytes = inputStream.read(buffer);  //in
            if (bytes < 0)
                break;
            out.write(buffer, 0, bytes);
            counter += bytes;
            System.out.println(counter);
        }

        out.close();
        in.close();
        inputStream.close();
        success =true;
    } catch (Exception ex) {
        System.out.println("Error: " + ex.toString());
    }
    return true;
}