int totalLength = 0;
for (int i = 0; i < source.length; i++)
   totalLength += source[i].length;
final int[] destination = new int[totalLength];
for (int len, i = 0, index = 0; i < source.length; i++, index += len)
        System.arraycopy(source[i], 0, destination, index, len = source[i].length);