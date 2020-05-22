public static void main(String[] args) {
    // args[0] should be the path that was requested, in which case you
    // could use
    if (args.length > 0) {
        java.io.File f = new java.io.File(args[0]);
        if (f != null && f.exists()) {
            try {
                System.out.println(f.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}