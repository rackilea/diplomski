BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
try {
    // generate output
} finally {
    bw.close();
}