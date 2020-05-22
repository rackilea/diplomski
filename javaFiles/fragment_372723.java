System.out.println(Arrays.toString(
        Unpooled.copiedBuffer(a, b).array()
));
byte[] byteArray = new byte[4];
a.readBytes(byteArray);
System.out.println(Arrays.toString(ArrayUtils.addAll(byteArray, b.array())));