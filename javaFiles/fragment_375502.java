try {
    FileOutputStream fout = new FileOutputStream("password.txt");
    byte b[] = pass.getBytes();
    fout.write(b);
} catch (Exception ee) {

}