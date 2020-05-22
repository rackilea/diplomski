/**
 * Saves the List of String[] to the File.
 * 
 * @param f
 * @param list
 * 
 * @throws IOException
 */
void saveList(File f, List<String[]> list) throws IOException {
    FileWriter fw = null;
    try {
        fw = new FileWriter(f);
        saveList(fw, list);
    } finally {
        if (null != fw) {
            // Ensure that fw is closed.
            fw.close();
        }
    }
}

/**
 * Saves the List of String[] to the Writer.
 * 
 * @param w
 * @param list
 * 
 * @throws IOException
 */
void saveList(Writer w, List<String[]> list) throws IOException {
    BufferedWriter bw = new BufferedWriter(w);
    for (int i = 0; i < list.size(); i++) {
        String[] dataEntry = list.get(i);
        for (int j = 0; j < dataEntry.length; j++) {
            bw.write("test1-2");
            // bw.append(dataEntry[j]+";");
        }
        bw.newLine();
    }
    bw.flush();
}

/**
 * Copies in's contents to out.
 * 
 * @param in
 *            Must not be null.
 * @param out
 *            Must not be null.
 * 
 * @throws IOException
 */
void copyStream(InputStream in, OutputStream out) throws IOException {
    if (null == in) {
        throw new NullPointerException("in must not be null");
    }
    if (null == out) {
        throw new NullPointerException("out must not be null");
    }
    byte[] buf = new byte[1024 * 8];
    int read = -1;
    while ((read = in.read(buf)) > -1) {
        out.write(buf, 0, read);
    }
}

/**
 * Copies in's contents to out, and ensures that in is closed afterwards.
 * 
 * @param in
 *            Must not be null.
 * @param out
 *            Must not be null.
 * 
 * @throws IOException
 */
void copyStreamAndCloseIn(InputStream in, OutputStream out) throws IOException {
    try {
        copyStream(in, out);
    } finally {
        in.close();
    }
}

public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String filepath = getServletContext().getRealPath("\\") + "temp";
    String filename = "csv" + dateFormat.format(date) + ".csv";
    File file = new File(filepath + filename);
    file.createNewFile();

    saveList(file, list);

    long length = file.length();
    response.setContentType("text/csv");
    response.addHeader("Content-Disposition", "attachment; filename=" + filename);
    response.setContentLength((int) length);

    copyStreamAndCloseIn(new FileInputStream(file), response.getOutputStream());
}