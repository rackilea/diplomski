public static boolean sameContent (File f1, File f2) throws IOException {
    if(f1.length()!=f2.length())return false;
    FileInputStream fis1 = new FileInputStream(f1);
    FileInputStream fis2 = new FileInputStream(f2);
    try {
        int byte1;
        while((byte1 = fis1.read())!=-1) {
            int byte2 = fis2.read();
            if(byte1!=byte2)return false;
        }
    } finally {
        fis1.close();
        fis2.close();
    }
    return true;
}