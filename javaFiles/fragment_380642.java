public static void main() throws FileNotFoundException {
    File src = null;
    File des = null;
    try {
        src = new File("src.txt");
        des = new File("des.txt");
        /*code*/
    } finally {
        /*closing code*/
        if (src != null) {
            System.out.print("After closing files:Size of src.txt:" + src.length() + " Bytes\t");
        }
        if (des != null) {
            System.out.println("Size of des.txt:" + des.length() + " Bytes");
        }
    }
}