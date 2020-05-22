final int x = 345421;
final String serialized = String.valueOf(x);
final int[] array = new int[serialized.length()];
for (int i = 0; i < serialized.length(); i++) {
    array[i] = Integer.valueOf(String.valueOf(serialized.charAt(i)));
}