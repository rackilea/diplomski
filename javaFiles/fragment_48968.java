Boolean status = isJPEG(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
System.out.println("Status: " + status);


private static Boolean isJPEG(File filename) throws Exception {
    DataInputStream ins = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
    try {
        if (ins.readInt() == 0xffd8ffe0) {
            return true;
        } else {
            return false;

        }
    } finally {
        ins.close();
    }
}