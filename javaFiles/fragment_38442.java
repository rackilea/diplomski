Path path = Paths.get("fileToDecrypt.p7m");
byte[] data = Files.readAllBytes(path);
try {
    System.out.println(new String(cmsDecrypt(data, key)));
} catch (Exception e) {
    e.printStackTrace();
}