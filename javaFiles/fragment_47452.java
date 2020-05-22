for(int i=0; i<MAX_TRIES; i++) {
    try {
        // your io code:
        boolean flag = fetch.read(file);
        file.delete();
        break;
    } catch(FileNotFoundException ex) {
        Thread.sleep(1000);
    }
}