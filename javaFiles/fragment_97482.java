private static void notify() {
    final File file = new File(".launched");

    if(!file.exists()) {

        // show your notification HERE

        file.createNewFile();
    }
}