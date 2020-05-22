byte[] input = {(byte)0xAB,(byte)0xCD};
MessageDigest md = MessageDigest.getInstance("SHA-256");
byte[] digest = md.digest(input);
for (int i=0; i < digest.length; i++) {
 sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
}
System.out.println(sb.toString());