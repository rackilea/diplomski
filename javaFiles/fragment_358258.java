try {
    ServerSocket s = create(new int[] { 3843, 4584, 4843 });
    System.out.println("listening on port: " + s.getLocalPort());
} catch (IOException ex) {
    System.err.println("no available ports");
}