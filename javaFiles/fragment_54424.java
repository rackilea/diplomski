// Read a file into a byte array, we are not interested
// in interpreting encodings, just plain bytes
final byte[] fileContent = Files.readAllBytes(Paths.get("pathToMyFile"));

// Iterate the content and display one byte per line
for (final byte data : fileContent) {
    // Convert to a regular 8-bit representation
    System.out.println(Integer.toBinaryString(data & 255 | 256).substring(1));
}