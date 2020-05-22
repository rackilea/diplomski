public static void main(String[] args) {
    try {
            ((ArrayList) null).get(0);
    } catch (RuntimeException e) {
        throw e;
    }
}