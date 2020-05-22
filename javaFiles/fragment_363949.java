String input = "Aä$$€h";
byte[] byteArray = input.getBytes(java.nio.charset.StandardCharsets.UTF_8);
int[] ints = new int[byteArray.length];
for(int i = 0; i < ints.length; i++) {
    ints[i] = Byte.toUnsignedInt(byteArray[i]);
}
System.out.println(java.util.Arrays.toString(ints));