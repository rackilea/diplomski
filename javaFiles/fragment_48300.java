System.out.println("Color planes: " + Arrays.toString(Arrays.copyOfRange(icoBytes, 10, 12)));
System.out.println("Bits per pixel: " + Arrays.toString(Arrays.copyOfRange(icoBytes, 12, 14)));
System.out.println("Img data size: " + Arrays.toString(Arrays.copyOfRange(icoBytes, 14, 18)) + " - " + ByteBuffer.wrap(Arrays.copyOfRange(icoBytes, 14, 18)).order(ByteOrder.LITTLE_ENDIAN).getInt());
System.out.println("Offset beginning data: " + Arrays.toString(Arrays.copyOfRange(icoBytes, 18, 22)) + " - " + ByteBuffer.wrap(Arrays.copyOfRange(icoBytes, 18, 22)).order(ByteOrder.LITTLE_ENDIAN).getInt());

final int imgSize = ByteBuffer.wrap(Arrays.copyOfRange(icoBytes, 14, 18)).order(ByteOrder.LITTLE_ENDIAN).getInt();
final int offset = ByteBuffer.wrap(Arrays.copyOfRange(icoBytes, 18, 22)).order(ByteOrder.LITTLE_ENDIAN).getInt();