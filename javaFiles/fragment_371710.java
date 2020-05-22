BufferedWriter bw = null;

try {
    bw = new BufferedWriter(new FileWriter("passwords.txt", true));
    bw.write(String.valueOf(pwd));
    bw.newLine();
    bw.flush();
} catch (IOException ioe) {
    ioe.printStackTrace();
}