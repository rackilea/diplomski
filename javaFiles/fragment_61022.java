byte[] data = Files.readAllBytes(Paths.get(fileName));
var search = "4:info".getBytes(StandardCharsets.US_ASCII);
int searchIdx = -1;
for (int i = 0; searchIdx == -1 && i < data.length - search.length; i++) {
    for (int j = 0; j < search.length; j++) {
        if (data[i + j] != search[j]) break;
        if (j == search.length - 1) searchIdx = i + j;
    }
}
if (searchIdx == -1) throw new IOException("Input torrent file does not contain marker");

var sha1 = MessageDigest.getInstance("SHA-1");
sha1.update(data, searchIdx, data.length - searchIdx);
byte[] hash = sha1.digest();
StringBuilder hex = new StringBuilder();
for (byte h : hash) hex.append(String.format("%02x", h));
System.out.println(hex);