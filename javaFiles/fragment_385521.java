byte[] bytes = new byte[chMsg.length / 2];
int byteI = 0;
for (int count = 0; count < chMsg.length; count = count + 2) {
    int b = Integer.parseInt(new String(chMsg, count, 2), 16); // 16 for hex
    bytes[byteI++] = (byte) b;
}