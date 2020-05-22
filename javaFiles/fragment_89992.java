public static void main(String[] args) {
    try {
        String val1 = args[0];
        String val2 = args[1];
    } catch (Exception e) { // <-- Here is where it gets tricky
        System.err.println(e.toString());
        Throwable thr = e.getCause();
        String msg = thr.getMessage();
        System.err.println(msg);
    }
}