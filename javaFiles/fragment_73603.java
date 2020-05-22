protected void done() {
    try {
        TableModel model = get();

        jTable3.setModel(model); // Use it here!

    } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
    }
}