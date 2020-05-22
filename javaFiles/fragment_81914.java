public static void main(String args[]) {
    Scanner inputScanner = new Scanner(System.in);
    String[] hashAlgos = { "MD2", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512" };
    System.out.print("Input: ");
    String input = inputScanner.next();
    try {
        byte[] fileContents = Files.readAllBytes(new File(input).toPath());
        for (String algo : hashAlgos) {
            MessageDigest md = MessageDigest.getInstance(algo);
            byte[] hash = md.digest(fileContents);
            System.out.printf("%s %s%n", algo, bytesToHex(hash));
        }
    } catch (NoSuchAlgorithmException | IOException e) {
        e.printStackTrace();
    }
}