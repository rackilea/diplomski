Scanner scan = new Scanner(new FilterInputStream(System.in) {
    @Override
    public void close() throws IOException {
        // do nothing here ! 
    }
});