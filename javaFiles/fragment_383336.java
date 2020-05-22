private static boolean available(int port) {
        try{
        Socket ignored = new Socket("localhost", port);
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }