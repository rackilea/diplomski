private void activateInstance() throws Exception {
    try {
        final int LOCK_PORT= 54321;
        ss = new ServerSocket(LOCK_PORT); // note the missing "ServerSocket" before ss
    } catch (Exception e) {
        System.out.println(e);
        throw e;
    }  
}