CipherInputStream c_decf = new CipherInputStream(decf,decipher);
FileOutputStream destf = new FileOutputStream(destfile);

cout = new CipherOutputStream(destf,decipher);

while ((read = c_decf.read()) != -1) {
    cout.write(read);
    cout.flush();
}