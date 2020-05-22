final int NUMBER_OF_IPS_TO_APPEND = 5000; // or whatever size
Charset charset = Charset.defaultCharset();
Path file = Paths.get("myfile.txt");

try (BufferedWriter writer = Files.newBufferedWriter(file, charset,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
    for (int i = 1; i <= NUMBER_OF_IPS_TO_APPEND; i++) {
        String ip = generateIPAddress(i);
        System.out.printf("Generated ip: %s\n", ip);
        writer.append(ip + "\n");
    }
} catch (IOException x) {
    System.err.format("IOException: %s\n", x);
}